package com.example.lab12w10day2.Controller;

import com.example.lab12w10day2.Api.ApiResponse;
import com.example.lab12w10day2.Model.Blog;
import com.example.lab12w10day2.Model.MyUser;
import com.example.lab12w10day2.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BolgController {
    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getMyBlogs(@AuthenticationPrincipal MyUser myUser) {
        return ResponseEntity.status(200).body(blogService.getMyBlogs(myUser.getId()));
    }


    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser,@RequestBody @Valid Blog blog) {
        blogService.addBlog(myUser.getId(), blog);
        return ResponseEntity.status(200).body(new ApiResponse("blog added"));
    }

    @PutMapping("/update/{blog_id}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blog_id,@RequestBody @Valid Blog blog) {
        blogService.updateBlog(myUser.getId(), blog_id, blog);
        return ResponseEntity.status(200).body(new ApiResponse("blog updated"));
    }

    @DeleteMapping("/delete/{blog_id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blog_id) {
        blogService.deleteBlog(myUser.getId(), blog_id);
        return ResponseEntity.status(200).body(new ApiResponse("blog deleted"));
    }
    @GetMapping("/get-blog-by-id/{blog_id}")
    public ResponseEntity getBlogById(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blog_id){
        return ResponseEntity.status(200).body(blogService.getBlogById(myUser.getId(), blog_id));
    }

    @GetMapping("/get-blog-by-title/{title}")
    public ResponseEntity getBlogByTitle(@AuthenticationPrincipal MyUser myUser,@PathVariable String title) {
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(myUser.getId(), title));
    }
}
