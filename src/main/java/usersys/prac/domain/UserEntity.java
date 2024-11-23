package usersys.prac.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import usersys.prac.dto.UserDto;

@Table(name="user_info")
@Getter
@NoArgsConstructor
@Entity
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @Builder
    public UserEntity(Long id, String username, String password, String email){
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
    }

    public UserDto toDto(){
        return UserDto.builder()
                        .id(id)
                        .username(username)
                        .password(password)
                        .email(email)
                        .build();
    }
    




}
