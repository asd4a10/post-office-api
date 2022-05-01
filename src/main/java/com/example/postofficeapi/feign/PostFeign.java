package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.ClientModel;
import com.example.postofficeapi.model.PostModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("post-core-api")
public interface PostFeign {
    @GetMapping("/post/check")
    String checkPostCoreApi();

    @GetMapping("/post/all")
    List<PostModel> getAllPosts();

    @GetMapping("/post}")
    PostModel getPostById(@RequestParam String postId);

    @PostMapping("/post")
    PostModel createPost(PostModel postModel);

    @PutMapping("/post")
    PostModel updatePostById(@RequestParam String postId, PostModel postModel);

    @DeleteMapping("/post")
    PostModel deletePostById(@RequestParam String postId);
}
