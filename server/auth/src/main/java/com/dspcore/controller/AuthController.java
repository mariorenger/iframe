package com.dspcore.controller;

import com.dspcore.model.User;
import com.dspcore.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class AuthController {
    final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/check-auth", method = RequestMethod.GET)
    @ResponseBody
    public String checkAuth(@RequestParam("key_login") String token, @RequestParam("username") String username){
        Optional<User> userOpt = userRepository.findByUsername(username);
        if(userOpt.isEmpty()){
            return "false";
        }

        User user = userOpt.get();
        if(user.getKeyLogin().equals(token)){
            return "true";
        }

        return "false";
    }
}
