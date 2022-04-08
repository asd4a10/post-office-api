package com.example.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailsModel {
    private String postId;
    private ClientModel senderId;
    private ClientModel receiverId;
    private String postItem;
    private String status;
}
