package CMS.REST.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

@Schema(
    name = "CommentDto",
    description = "Data transfer object representing a comment made by a user on a post."
)
public class CommentDto {

    @Schema(
        description = "Unique identifier of the comment"
    )
    private long id;


    @Schema(
        description = "Name of the user who posted the comment"
    )
    // name should not be null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;


    @Schema(
        description = "Email address of the user who posted the comment"
    )
    // email should not be null or empty
    // email field validation
    @NotEmpty
    @Email
    private String email;


    @Schema(
        description = "Content of the comment (minimum 10 characters)"
    )
    // comment should not be null or empty
    // comment body must be minimum 10 characters
    @NotEmpty
    @Size(min=10, message = "Comment body must be minimum 10 characters") 
    private String body;

}
