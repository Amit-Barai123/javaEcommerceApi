package com.ecommerce.amit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.amit.dto.UserDto;

@Service
public interface UserService {
        UserDto getUserById(Integer id);
        List<UserDto> getAllUser();
        List<UserDto> getUserByRole(String Role );
        String resetPassword(Integer UserId, String newPassword);

         List<UserDto> getAllUserByPagenation(Integer pageNo, Integer pagesize);


}
