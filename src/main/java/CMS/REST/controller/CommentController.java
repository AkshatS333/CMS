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

@RestController
@RequestMapping("/cms/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable ("postId") long postId, @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto),HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments")
    public  List<CommentDto> getCommentsByPostId(@PathVariable("postId") Long postId){
        return commentService.getCommentsByPostId(postId); 
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable ("postId") Long postId, @PathVariable ("id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }


    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable ("postId") Long postId, @PathVariable("id") Long id, @RequestBody CommentDto commentDto){

        CommentDto updaCommentDto = commentService.updateComment(postId, id, commentDto);
        return new ResponseEntity<>(updaCommentDto, HttpStatus.OK);
    }



    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable ("postId") Long postId, @PathVariable ("id") Long commentId){

        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully",HttpStatus.OK);
    }
    

}
