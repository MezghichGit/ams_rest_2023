package com.sip.ams.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Role;
import com.sip.ams.repositories.RoleRepository;


@RestController
@RequestMapping("/role/")
public class RoleController {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

	@GetMapping("list")
    public String listRoles(Model model) {

    	List<Role> roles = (List<Role>) roleRepository.findAll();
    	long nbr =  roleRepository.count();
    	if(roles.size()==0)
    		roles = null;
        model.addAttribute("roles", roles);
        model.addAttribute("nbr", nbr);
        return "role/listRoles";
    }



    @PostMapping("add")
    public Map addRole(@RequestParam("role") String role) {
        Map<String,String> res = new HashMap<>();
        Role existRole = null;
        String added = "True";
        //System.out.println(role);
        Role r = new Role(role);
         existRole = roleRepository.findByRole(role);
        if(existRole == null) {
            Role rSaved = roleRepository.save(r);
            System.out.println("role = " + rSaved);
        }
        else{
            System.out.println("role existe déjà");
            added = "False";
        }
        res.put("role",role);
        return res;
    }


}
