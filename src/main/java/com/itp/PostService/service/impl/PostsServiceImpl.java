package com.itp.PostService.service.impl;


import com.itp.PostService.dto.PostsRequestDto;
import com.itp.PostService.dto.PostsResponseDto;
import com.itp.PostService.exceptions.ResourceNotFoundException;
import com.itp.PostService.mapper.PostMapper;
import com.itp.PostService.model.Post;
import com.itp.PostService.repository.PostRepository;
import com.itp.PostService.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsServiceImpl implements IPostsService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(PostsRequestDto postsRequestDto) {
        Post post = PostMapper.mapToPost(postsRequestDto);
        postRepository.save(post);
    }

    @Override
    public List<PostsResponseDto> getPosts() {
        return postRepository.findAll().stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostsResponseDto getPost(String postId) {
        return postRepository.findById(postId)
                .map(PostMapper::mapToPostDto)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
    }

    @Override
    public List<PostsResponseDto> getPostsByUserId(String userId) {
        List<Post> posts = postRepository.findByUserId(userId);

        if (posts.isEmpty()) {
            throw new ResourceNotFoundException("Post", "userId", userId);
        }

        return posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deletePost(String postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepository.delete(post);
    }

    @Override
    public void updatePost(String postId, PostsRequestDto postsRequestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        post.setUserId(postsRequestDto.getUserId());
        post.setTitle(postsRequestDto.getTitle());
        post.setCaption(postsRequestDto.getCaption());
        postRepository.save(post);
    }

}
