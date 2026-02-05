package CMS.REST.payload;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
    description = "PostDto Model Information"
)
public class PostDto {
    private Long id;


    @Schema(
        description = "CMS Post Title"
    )
    // title should not be null or empty
    // title should have atleast 2 or more characters
    @NotEmpty
    @Size(min=2, message = "Post title should have at least 2 characters")
    private String title;



    @Schema(
        description = "CMS Post Description"
    )
    // post description should be not null or empty
    // post description should have atleast 10 or more characters
    @NotEmpty
    @Size(min=10, message = "Post description should have atleast 10 or more characters")
    private String description;


    @Schema(
        description = "CMS Post content"
    )
    // content should not be empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    @Schema(
        description = "CMS Post category's"
    )
    private Long categoryId;

}
