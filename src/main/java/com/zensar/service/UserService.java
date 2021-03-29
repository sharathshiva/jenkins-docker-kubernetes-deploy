package com.zensar.service;

import com.zensar.model.User;
import com.zensar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   /* public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }*/

    public Iterable<User> list(){
        return userRepository.findAll();
    }
    public void save(List<User> users) {
        userRepository.saveAll(users);
    }

    public User getUserBYId(Integer id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new Exception("couldnt find dog with id:"+id));
    }

    public User saveProfileTODB(User user) {
            return userRepository.save(user);
    }

    public void deleteProfileById(int id) {
        userRepository.deleteById(id);
    }

    public User updateProfile(User user) {
        return userRepository.save(user);
    }
}
