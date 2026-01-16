package com.ecommerce.amit.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.UserDto;
import com.ecommerce.amit.entity.Role;
import com.ecommerce.amit.entity.User;
import com.ecommerce.amit.repo.UserRepo;
import com.ecommerce.amit.service.UserService;

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto getUserById(Integer id) {
        User user = new User();
     user=   userRepo.findById(id).orElseThrow();

     UserDto userDto =UserDto.builder()
     .name(user.getName())
     .email(user.getEmail())
     .role(user.getRole().name())
     .build();
      

     return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
       List<User> users = userRepo.findAll();
       List<UserDto> usersData = users.stream().map(
e->{
    UserDto userDto = UserDto.builder()
    .name(e.getName())
    .email(e.getEmail())
    .role(e.getRole().name()).build();
    return userDto;
}
       ).toList();

       return usersData;
    }

    @Override
    public List<UserDto> getUserByRole(String role) {
         List<User> users = userRepo.findByRole(Role.valueOf(role));

          List<UserDto> usersData = users.stream().map(
e->{
    UserDto userDto = UserDto.builder()
    .name(e.getName())
    .email(e.getEmail())
    .role(e.getRole().name()).build();
    return userDto;
}
       ).toList();

       return usersData;
    }

    @Override
    public String resetPassword(Integer UserId, String newPassword) {
       User user  = userRepo.findById(UserId).orElseThrow();
       user.setPassword(bCryptPasswordEncoder.encode(newPassword));

        userRepo.save(user);

       return "password changed sucessfully";

    }

    @Override
    public List<UserDto> getAllUserByPagenation(Integer pageNo, Integer pagesize) {
      
        Pageable pageable = PageRequest.of(pageNo, pagesize);


       Page<User> users = userRepo.findAll(pageable);
       List<UserDto> usersData = users.getContent().stream().map(
e->{
    UserDto userDto = UserDto.builder()
    .name(e.getName())
    .email(e.getEmail())
    .role(e.getRole().name()).build();
    return userDto;
}
       ).toList();

       return usersData;
    }
    
}
