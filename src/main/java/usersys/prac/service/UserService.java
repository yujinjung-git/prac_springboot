package usersys.prac.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import usersys.prac.domain.UserEntity;
import usersys.prac.domain.UserRepository;
import usersys.prac.dto.UserJoinDto;
import usersys.prac.dto.UserLoginDto;

@Slf4j
@Service
@RequiredArgsConstructor


public class UserService {
    private final UserRepository userRepository;

    public UserJoinDto join(UserJoinDto userJoinDto){
        userRepository.save(userJoinDto.toEntity());
        return userJoinDto;
    }

    public boolean login(UserLoginDto userLoginDto){
        UserEntity userEntity = userRepository.findByUsername(userLoginDto.getUsername());
        String password=userLoginDto.getPassword();
        return userEntity != null && password.matches(userEntity.getPassword());
    }


}
