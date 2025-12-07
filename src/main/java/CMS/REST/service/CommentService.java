package CMS.REST.service;

import java.util.List;

import CMS.REST.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(Long id, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto); 

    void deleteComment(Long postId, Long commentId);

}
