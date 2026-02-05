package CMS.REST.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    name = "LoginDto",
    description = "Request payload for user authentication using username or email and password."
)
public class LoginDto {

    @Schema(
        description = "Username or email address of the user"
    )
    private String usernameOrEmail;

    @Schema(
        description = "User account password"
    )
    private String password;

}
