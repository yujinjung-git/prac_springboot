package usersys.prac.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDto {
    @NotBlank(message = "필수 입력 값입니다.")
    private String username;

    @NotBlank(message = "필수 입력 값입니다.")
    private String password;

}
