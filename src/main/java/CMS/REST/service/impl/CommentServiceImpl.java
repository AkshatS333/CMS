package CMS.REST.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import CMS.REST.entity.Comment;
import CMS.REST.entity.Post;
import CMS.REST.exception.CmsAPIException;
import CMS.REST.exception.ResourceNotFoundException;
import CMS.REST.payload.CommentDto;
import CMS.REST.repository.CommentRepository;
import CMS.REST.repository.PostRepository;
import CMS.REST.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.mapper = mapper;
    }

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);

        // retreive post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // set post to comment entity
        comment.setPost(post);

        // comment entity to DB
        Comment newComment = commentRepository.save(comment);

        return mapToDto(newComment);

    }

    private CommentDto mapToDto(Comment comment) {

        CommentDto commentDto = mapper.map(comment, CommentDto.class);

        // CommentDto commentDto = new CommentDto();
        // commentDto.setId(comment.getId());
        // commentDto.setName(comment.getName());
        // commentDto.setEmail(comment.getEmail());
        // commentDto.setBody(comment.getBody());

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {

        Comment comment = mapper.map(commentDto, Comment.class); 

        // Comment comment = new Comment();
        // comment.setId(commentDto.getId());
        // comment.setName(commentDto.getName());
        // comment.setEmail(commentDto.getEmail());
        // comment.setBody(commentDto.getBody());

        return comment;
    }

    // To provide comments belonging to post id

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {

        // retrieve comment by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        // convert list of comment entities to list of DTO's
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());

    }

    // Method for getting through postId and commentId

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {

        // retreive post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new CmsAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to Post.");
        }

        return mapToDto(comment);

    }

    // Method to update comment via postId and commentId

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) {

        // retreive post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new CmsAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment updatedComment = commentRepository.save(comment);

        return mapToDto(updatedComment);
    }

    // Method to delete comment via postId and commentId

    @Override
    public void deleteComment(Long postId, Long commentId) {

        // retreive post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new CmsAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to Post.");
        }

        commentRepository.delete(comment);

    }

}
