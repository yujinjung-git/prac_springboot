package usersys.prac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import usersys.prac.domain.UserRepository;
import usersys.prac.dto.UserJoinDto;
import usersys.prac.dto.UserLoginDto;
import usersys.prac.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository){
        this.userService=userService;
        this.userRepository=userRepository;
    }

    @PostMapping("/join")
    public UserJoinDto join(@RequestBody UserJoinDto userJoinDto) {
        return userService.join(userJoinDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userLoginDto) {
        boolean isAuth= userService.login(userLoginDto);
        if(isAuth){
            log.info("username = ", userLoginDto.getUsername(), "password = ", userLoginDto.getPassword());
            return "good";
        }
        else{
            return "bad";
        }
        
    }
    
    

}
