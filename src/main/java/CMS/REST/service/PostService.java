package CMS.REST.service;

import java.util.List;

import CMS.REST.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto posstDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
