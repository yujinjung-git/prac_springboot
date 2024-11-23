package usersys.prac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import usersys.prac.domain.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserJoinDto {

    private String username;
    private String password;
    private String email;

    public UserEntity toEntity(){
        UserEntity userEntity = UserEntity.builder()
                                            .username(username)
                                            .password(password)
                                            .email(email)
                                            .build();
        return userEntity;
    }

}
