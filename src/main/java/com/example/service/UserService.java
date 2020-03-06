package com.example.service;

import com.example.model.Role;
import com.example.model.Status;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    }

    public User register(User user){
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        return null;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    public List<User> getUserList(){
        return new ArrayList<>(userRepository.findAll());
    }

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
