package usersys.prac.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import usersys.prac.domain.UserEntity;


@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
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

    @Builder
    public UserDto(Long id, String username, String password, String email){
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
    }

}
