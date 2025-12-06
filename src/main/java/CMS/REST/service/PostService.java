package CMS.REST.service;


import CMS.REST.payload.PostDto;
import CMS.REST.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto posstDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
