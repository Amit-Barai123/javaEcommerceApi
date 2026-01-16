package com.ecommerce.amit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.amit.dto.UserDto;
import com.ecommerce.amit.entity.Role;
import com.ecommerce.amit.entity.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    
    User findByEmail(String email );
    List<User>  findByRole(Role role);


}
