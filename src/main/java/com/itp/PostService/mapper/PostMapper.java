package com.itp.PostService.mapper;

import com.itp.PostService.dto.PostsRequestDto;
import com.itp.PostService.dto.PostsResponseDto;
import com.itp.PostService.model.Post;

public class PostMapper {
    public static PostsResponseDto mapToPostDto(Post post) {
        return PostsResponseDto.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .caption(post.getCaption())
                .build();
    }

    public static Post mapToPost(PostsRequestDto postsRequestDto) {
        return Post.builder()
                .userId(postsRequestDto.getUserId())
                .title(postsRequestDto.getTitle())
                .caption(postsRequestDto.getCaption())
                .build();
    }
}
