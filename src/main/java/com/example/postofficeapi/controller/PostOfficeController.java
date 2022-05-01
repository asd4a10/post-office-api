package com.example.postofficeapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post-office")
public class PostOfficeController {
    @GetMapping("/check")
    public String check() {
        return "post office is working";
    }
}
