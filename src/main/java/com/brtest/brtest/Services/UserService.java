package com.brtest.brtest.Services;

import com.brtest.brtest.Entities.User.User;
import com.brtest.brtest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.security.cert.TrustAnchor;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }





    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int Id){
        return userRepository.findById(Id).orElse(null);
    }

    public Boolean DeleteUser(User user){
        userRepository.deleteById(user.getId());
        return true;
    }

    public Boolean updateUser(User user){
        userRepository.saveAndFlush(user);
        return true;
    }

    public Boolean AddUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
