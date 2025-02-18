package com.itp.PostService.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
public class PostsRequestDto {

    @NotEmpty(message = "User Id cannot be null or empty")
    private String userId;

    @NotEmpty(message = "Title cannot be null or empty")
    private String title;

    @Max(value = 255, message = "Caption cannot be more than 255 characters")
    private String caption;
}
