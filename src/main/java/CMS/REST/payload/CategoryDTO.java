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
    name = "CategoryDTO",
    description = "Data transfer object representing a category used to group related posts or content."
)
public class CategoryDTO {


    @Schema(
        description = "Unique identifier of the category"
    )
    private Long id;

    @Schema(
        description = "Name of the category"
    )
    private String name;


    @Schema(
        description = "Detailed description of the category"
    )
    private String description;

}
