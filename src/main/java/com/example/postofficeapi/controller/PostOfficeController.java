package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.feign.PostFeign;
import com.example.postofficeapi.model.ClientModel;
import com.example.postofficeapi.model.DetailsModel;
import com.example.postofficeapi.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post-office")
public class PostOfficeController {
    @Autowired
    ClientFeign clientFeign;
    @Autowired
    PostFeign postFeign;

    @GetMapping("/check")
    public String check(){
        return "post office is working";
    }
    //POST-CORE-API
    @GetMapping("/post/check")
    public String checkPostFeign(){
        return postFeign.checkPostCoreApi();
    }
    @GetMapping("/post/all")
    public List<PostModel> getAllPosts(){
        return postFeign.getAllPosts();
    }
    @GetMapping("/post/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postFeign.getPostById(postId);
    }
    //CLIENT-CORE-API
    @GetMapping("/client/check")
    public String checkClientFeign(){
        return clientFeign.checkClientCoreApi();
    }
    @GetMapping("/client/all")
    public List<ClientModel> getAllClients(){
        return clientFeign.getAllClients();
    }
    @GetMapping("/client/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId){
        return clientFeign.getClientById(clientId);
    }
    @GetMapping("/post-details/{postId}")
    public DetailsModel getDetailsByPostId(@PathVariable String postId){
        PostModel post= postFeign.getPostById(postId);
        ClientModel sender= clientFeign.getClientById(post.getClientId());
        ClientModel receiver= clientFeign.getClientById(post.getPostRecipientId());
        DetailsModel details= new DetailsModel(post.getPostId(), sender, receiver, post.getPostItem(), post.getStatus());
        return details;
    }
}
