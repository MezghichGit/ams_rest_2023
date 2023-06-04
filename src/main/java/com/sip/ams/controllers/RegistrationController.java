package com.sip.ams.controllers;

import java.util.Arrays;
import java.util.HashSet;

import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;
import com.sip.ams.repositories.RoleRepository;
import com.sip.ams.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User createNewUser(@RequestBody User user) {

        //User userExists = userService.findUserByEmail(user.getEmail());

        //Role userRole = roleRepository.findByRole("ADMIN");
        //Role userRole2 =


        //Set<Role> role_user = user.getRoles();
        // user.setRoles(new HashSet<Role>(role_user));


        Role userRole = roleRepository.findByRole(user.getTemp());
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        userService.saveUser(user);

        return user;
    }

}
