package com.itp.PostService.repository;

import com.itp.PostService.dto.PostsResponseDto;
import com.itp.PostService.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findByUserId(String userId);
}
