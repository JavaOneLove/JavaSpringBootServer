package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUserList(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
   // @Override
   // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  //      return userRepository.findByUsername(username);
   // }
    public void updateProfile(User user, String password, String email, String username) {
        String userEmail = user.getEmail();
        String userName = user.getUsername();
        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));
        if (username != userName){
            user.setUsername(username);
        }
        if (isEmailChanged) {
            user.setEmail(email);
        }
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        userRepository.save(user);

    }
    public void Save(User user){
        userRepository.save(user);
    }
}
