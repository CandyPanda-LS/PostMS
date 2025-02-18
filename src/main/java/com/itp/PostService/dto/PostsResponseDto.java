package com.itp.PostService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostsResponseDto {

    private String id;
    private String userId;
    private String title;
    private String caption;
}
