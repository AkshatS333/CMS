package CMS.REST.service;


import java.util.List;

import CMS.REST.payload.PostDto;
import CMS.REST.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto posstDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostsByCategory(Long categoryId);

}
