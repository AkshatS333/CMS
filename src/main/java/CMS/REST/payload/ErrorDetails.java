package CMS.REST.payload;

import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(
    name = "ErrorDetails",
    description = "Standard error response containing details about an exception or failure that occurred while processing the request."
)
public class ErrorDetails {

    @Schema(
        description = "Timestamp indicating when the error occurred"
    )
    private Date timestamp;

    @Schema(
        description = "Human-readable error message describing the problem"
    )
    private String message;

    @Schema(
        description = "Additional details about the error, such as request path or validation information"
    )
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    

}
