package com.ecommerce.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.amit.dto.ChangePasswordReq;
import com.ecommerce.amit.dto.UserDto;
import com.ecommerce.amit.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
 
     UserDto user = service.getUserById(id);

     return ResponseEntity.status(200).body(user);

    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos = service.getAllUser();

             return ResponseEntity.status(200).body(userDtos);


    }

    
    @GetMapping("/ ")
    public ResponseEntity<List<UserDto>> getAllUsersByRole(@RequestParam String role ){
        List<UserDto> userDtos = service.getUserByRole(role);

             return ResponseEntity.status(200).body(userDtos);


    }


    @PostMapping("/chagepassword")
     public ResponseEntity<String> resetPassword(@RequestBody ChangePasswordReq req){

        String s = service.resetPassword(req.getUserId(),req.getNewPassword());

                     return ResponseEntity.status(200).body(s);


     } 
    
     @GetMapping("/getUsersbyPage")
      public ResponseEntity<List<UserDto>> getAllUserByPagenation(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "2") Integer pagesize){
        List<UserDto> users = service.getAllUserByPagenation(pageNo, pagesize);
        return ResponseEntity.ok(users);
      }



}
