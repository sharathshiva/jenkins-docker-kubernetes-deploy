package com.zensar.controller;

import com.zensar.model.User;
import com.zensar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/profiles")
public class UserController {


    @Autowired
    private UserService userService;

   /* public UserController(UserService userService){
        this.userService = userService;
    }*/

    @GetMapping
    public  Iterable<User> list(){
        return userService.list();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(required = true)Integer id) throws Exception {
        return userService.getUserBYId(id);
    }

    @PostMapping("/fileupload")
    public User saveProfile(@RequestBody User user)  {
        return userService.saveProfileTODB(user);

    }

    @GetMapping("/delete/{id}")
    public void deleteProfileID(@PathVariable("id") int id){
         userService.deleteProfileById(id);
    }

    @PutMapping("/update")
    public User profileUpdate(@RequestBody User user){
        return userService.updateProfile(user);
    }

}
