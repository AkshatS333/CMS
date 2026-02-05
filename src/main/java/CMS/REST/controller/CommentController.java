package CMS.REST.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CMS.REST.payload.CommentDto;
import CMS.REST.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cms/")
@Tag(
    name = "CRUD REST APIs for Comment Resource"
)
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
        summary = "Create Comment REST API",
        description = "Create Comment REST API is used to save a comment in the database."
    )
    @ApiResponse(
        responseCode = "201",
        description = "Http Status 201 CREATED"
    )

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable ("postId") long postId, @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto),HttpStatus.CREATED);
    }

    @Operation(
        summary = "Get all Comments by Post Id REST API",
        description = "Get all Comments by Post Id REST API is used to get all comment for particular post in the database."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 SUCCESS"
    )

    @GetMapping("posts/{postId}/comments")
    public  List<CommentDto> getCommentsByPostId(@PathVariable("postId") Long postId){
        return commentService.getCommentsByPostId(postId); 
    }



    @Operation(
        summary = "Get a Comment by Post Id REST API",
        description = "Get a Comment by Post Id REST API is used to get a particular comment for particular post in the database."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 SUCCESS"
    )


    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable ("postId") Long postId, @PathVariable ("id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }


    @Operation(
        summary = "Update a Comment by Post Id REST API",
        description = "Update a Comment by Post Id REST API is used to update a particular comment for particular post in the database."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 SUCCESS"
    )


    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable ("postId") Long postId, @PathVariable("id") Long id, @Valid @RequestBody CommentDto commentDto){

        CommentDto updaCommentDto = commentService.updateComment(postId, id, commentDto);
        return new ResponseEntity<>(updaCommentDto, HttpStatus.OK);
    }


    @Operation(
        summary = "Delete a Comment by Post Id REST API",
        description = "Delete a Comment by Post Id REST API is used to delete a particular comment for particular post in the database."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 SUCCESS"
    )


    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable ("postId") Long postId, @PathVariable ("id") Long commentId){

        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully",HttpStatus.OK);
    }
    

}
