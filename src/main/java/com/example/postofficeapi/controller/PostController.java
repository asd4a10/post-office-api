package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.feign.PostFeign;
import com.example.postofficeapi.model.ClientModel;
import com.example.postofficeapi.model.PostDetailsModel;
import com.example.postofficeapi.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-office/post")
public class PostController {
    @Autowired
    PostFeign postFeign;
    @Autowired
    ClientFeign clientFeign;

    @GetMapping("check")
    public String checkPostFeign() {
        return postFeign.checkPostCoreApi();
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping
    public PostModel getPostById(@RequestParam String postId) {
        return postFeign.getPostById(postId);
    }

    @PostMapping
    public PostModel createPost(@RequestBody PostModel postModel) {
        return postFeign.createPost(postModel);
    }

    @PutMapping
    public PostModel updatePostById(@RequestParam String postId, @RequestBody PostModel postModel) {
        return postFeign.updatePostById(postId, postModel);
    }

    @DeleteMapping
    public PostModel deletePostById(@RequestParam String postId) {
        return postFeign.deletePostById(postId);
    }

    @GetMapping("/details")
    public PostDetailsModel getDetailsByPostId(@RequestParam String postId) {
        PostModel post = postFeign.getPostById(postId);
        ClientModel sender = clientFeign.getClientById(post.getClientId());
        ClientModel receiver = clientFeign.getClientById(post.getPostRecipientId());
        PostDetailsModel details = new PostDetailsModel(post.getPostId(), sender, receiver, post.getPostItem(), post.getStatus());
        return details;
    }
}
