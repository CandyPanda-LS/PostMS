package com.itp.PostService.controller;


import com.itp.PostService.constants.PostsConstants;
import com.itp.PostService.dto.PostsRequestDto;
import com.itp.PostService.dto.PostsResponseDto;
import com.itp.PostService.dto.ResponseDto;
import com.itp.PostService.service.IPostsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@Tag(name = "Posts", description = "Endpoints to manage posts")
@Validated
public class PostsController {

    @Autowired
    IPostsService postsService;

    @Operation(
            summary = "Create a post",
            description = "Create a post with the given userId, title and caption"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createPost(@Valid @RequestBody PostsRequestDto postsRequestDto){
        log.info("Received Post: userId={}, title={}, caption={}",
                postsRequestDto.getUserId(), postsRequestDto.getTitle(), postsRequestDto.getCaption());
        postsService.createPost(postsRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(PostsConstants.STATUS_201, PostsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Get all posts",
            description = "Get all posts"
    )
    @GetMapping("/posts")
    public ResponseEntity<List<PostsResponseDto>> getPosts(){
        log.info("Received request to get all posts");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postsService.getPosts());
    }

    @Operation(
            summary = "Get post by id",
            description = "Get post by id"
    )
    @GetMapping("/posts/post/{postId}")
    public ResponseEntity<PostsResponseDto> getPost(@PathVariable String postId){
        log.info("Received request to get post with id={}", postId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postsService.getPost(postId));
    }

    @Operation(
            summary = "Get posts by userId",
            description = "Get posts by userId"
    )
    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<PostsResponseDto>> getPostsByUserId(@PathVariable String userId){
        log.info("Received request to get posts with userId={}", userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postsService.getPostsByUserId(userId));
    }

    @Operation(
            summary = "Delete post by id",
            description = "Delete post by id"
    )
    @DeleteMapping("/posts/post/{postId}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable String postId){
        log.info("Received request to delete post with id={}", postId);
        postsService.deletePost(postId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(PostsConstants.STATUS_200, PostsConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Update post by id",
            description = "Update post by id"
    )
    @PutMapping("/posts/post/{postId}")
    public ResponseEntity<ResponseDto> updatePost(@PathVariable String postId,@Valid @RequestBody PostsRequestDto postsRequestDto){
        log.info("Received request to update post with id={}", postId);
        postsService.updatePost(postId, postsRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(PostsConstants.STATUS_200, PostsConstants.MESSAGE_200));
    }

}
