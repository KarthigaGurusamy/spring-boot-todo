package com.karthigaspringboottodo.springboottodo.service;

import com.karthigaspringboottodo.springboottodo.model.AppUser;
import com.karthigaspringboottodo.springboottodo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser userLogin(AppUser appUser) {
        Optional<AppUser> loggedInUser =  appUserRepository.findAll()
                .stream()
                .filter(user-> user.getUsername().equals(appUser.getUsername()) && user.getPassword().equals(appUser.getPassword()))
                .findFirst();

//        AppUser loggedInUser = appUserRepository.findUser(appUser.getUsername(),appUser.getPassword());
        return loggedInUser.orElse(null);
    }

    public AppUser userRegister(AppUser appUser) {
        appUserRepository.save(appUser);
        return appUser;
    }
}
