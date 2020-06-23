package com.example.controller;


import com.example.model.Role;
import com.example.model.Status;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/admin")
//@PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
public class AdminRestController {

    private RoleRepository roleRepository;
    private UserService userService;
    private Logger LOGGER;

    @Autowired
    public AdminRestController(UserService userService,RoleRepository roleRepository){
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping(path = "/userList")
    public ModelAndView getUserList() {
        ModelAndView model = new ModelAndView();
        List<User> usersList = userService.getUserList();
        model.addObject(usersList);
        model.setViewName("getUserList");
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userList : Список пользователей получен");
        return model;
    }

    @GetMapping("/userDetails/{id}")
    public ModelAndView userDetails(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView();
        model.addObject(userService.findById(id));
        model.setViewName("getUserDetails");
        List<String> rolesList = new ArrayList<>();
        rolesList.add("ROLE_USER");
        rolesList.add("ROLE_ADMIN");
        rolesList.add("ROLE_MANAGER");
        model.addObject("roleList",rolesList);
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userDetails/{id} :Пользователь получен");
        return model;
    }

    @GetMapping("/userDetailsName/{name}")
    public User userDetails(@PathVariable("name") String username) {
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userDetailsName/{name} :Пользователь получен");
        return userService.findByUsername(username);
    }
    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id){
            userService.delete(id);
    }

    @GetMapping("/profile")
    public ModelAndView profile(@AuthenticationPrincipal Principal principal){
        ModelAndView model = new ModelAndView();
        model.addObject(userService.findByUsername("admin"));// principal.getName()
        model.setViewName("AdminProfile");
        model.addObject("users",userService.getUserList());
        return model;
    }
    @PostMapping("/updateUser")
    public void updateUserProfile(@AuthenticationPrincipal Principal principal,User user){
        if (user != null) {
            User userChange = userService.findByUsername(principal.getName());
            String usr = user.getUsername();
            String eml = user.getEmail();
            String pas = user.getPassword();
            userService.updateProfile(userChange, pas, eml, usr);
            LOGGER = Logger.getLogger(AdminRestController.class.getName());
            LOGGER.log(Level.INFO, "AdminController: /updateUser :Пользователь изменен");
        }
    }
    @PostMapping("/updateUser2")
    public ModelAndView updateUserProfile(@RequestParam("userId") User user,
                                          @RequestParam(value = "ROLE_USER", required = false) String roleUser,
                                          @RequestParam(value = "ROLE_ADMIN", required = false) String roleAdmin,
                                          @RequestParam(value = "ROLE_MANAGER", required = false) String roleManager
    ){
        if (user != null) {
            User usersave = userService.findByUsername(user.getUsername());
            List<Role> roles = new ArrayList<>();
            usersave.getRoles().clear();
            Role role = null;
            if (roleUser != null && roleUser.equals("on"))
            role = roleRepository.findByName("ROLE_USER");
            if (roleAdmin != null && roleAdmin.equals("on"))
            role = roleRepository.findByName("ROLE_ADMIN");
            if (roleManager != null && roleManager.equals("on"))
            role = roleRepository.findByName("ROLE_MANAGER");
            roles.add(role);
            usersave.setRoles(roles);
            usersave.setStatus(Status.ACTIVE);
            usersave.setCreated(LocalDateTime.now());
            usersave.setUpdated(LocalDateTime.now());
            userService.Save(usersave);
            LOGGER = Logger.getLogger(AdminRestController.class.getName());
            LOGGER.log(Level.INFO, "AdminController: /updateUser :Пользователь изменен ");
        }
        return new ModelAndView("redirect:/api/admin/profile");
    }

}
