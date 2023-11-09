package com.karthigaspringboottodo.springboottodo.controller;

import com.karthigaspringboottodo.springboottodo.model.AppUser;
import com.karthigaspringboottodo.springboottodo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class AppUserController {
    @Autowired
    private AppUserService appUserService;


    @PostMapping("/login")
    public AppUser userLogin(@RequestBody AppUser appUser)
    {
        return appUserService.userLogin(appUser);
    }

    @PostMapping("/register")
    public AppUser userRegister(@RequestBody AppUser appUser)
    {
        return appUserService.userRegister(appUser);
    }

}
