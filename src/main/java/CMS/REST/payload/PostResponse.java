package CMS.REST.payload;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Schema(
    name = "PostResponse",
    description = "Paginated response containing a list of posts along with pagination metadata."
)
public class PostResponse {

    @Schema(
        description = "List of posts for the current page"
    )
    private List<PostDto> content;

    @Schema(
        description = "Current page number (zero-based index)"
    )
    private int pageNo;


    @Schema(
        description = "Number of posts per page"
    )
    private int pageSize;


    @Schema(
        description = "Total number of posts available"
    )
    private long totalElements;

    @Schema(
        description = "Total number of pages available"
    )
    private int totalPages;

    @Schema(
        description = "Indicates whether this is the last page of the result set"
    )
    private boolean last;


}
