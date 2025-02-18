package com.itp.PostService.service;


import com.itp.PostService.dto.PostsRequestDto;
import com.itp.PostService.dto.PostsResponseDto;

import java.util.List;

public interface IPostsService {
    /**
     * Create an account
     * @param postsRequestDto
     */
    void createPost(PostsRequestDto postsRequestDto);

    List<PostsResponseDto> getPosts();

    PostsResponseDto getPost(String postId);

    List<PostsResponseDto> getPostsByUserId(String userId);

    void deletePost(String postId);

    void updatePost(String postId, PostsRequestDto postsRequestDto);
}
