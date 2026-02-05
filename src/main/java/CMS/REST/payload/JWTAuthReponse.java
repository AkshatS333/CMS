package CMS.REST.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
    name = "JWTAuthResponse",
    description = "Response payload containing the JWT access token used for authenticating API requests."
)
public class JWTAuthReponse {

    @Schema(
        description = "JWT access token issued after successful authentication"
    )
    private String accessToken;

    @Schema(
        description = "Type of authentication token, typically 'Bearer'"
    )
    private String tokenType="Bearer";

}
