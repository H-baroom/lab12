package com.example.lab12w10day2.Service;

import com.example.lab12w10day2.Api.ApiException;
import com.example.lab12w10day2.Model.Blog;
import com.example.lab12w10day2.Model.MyUser;
import com.example.lab12w10day2.Repository.AuthRepository;
import com.example.lab12w10day2.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository bolgRepository;
    private final AuthRepository authRepository;

    public List<Blog> getMyBlogs(Integer user_id) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("user not found");
        }
        return bolgRepository.findAllByUser(myUser);
    }

    public void addBlog(Integer user_id,Blog blog) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("user not found");
        }
        blog.setUser(myUser);
        bolgRepository.save(blog);
    }

    public void updateBlog(Integer user_id,Integer blog_id,Blog blog) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("user not found");
        }
        Blog blog1 = bolgRepository.findBlogById(blog_id);
        if (blog1 == null) {
            throw new ApiException("blog not found");
        }
        if (myUser.getId() == blog1.getUser().getId()) {
            blog1.setTitle(blog.getTitle());
            blog1.setBody(blog.getBody());
            bolgRepository.save(blog1);
        }else{
            throw new ApiException("user does not have this blog");
        }
    }

    public void deleteBlog(Integer user_id,Integer blog_id) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("user not found");
        }
        Blog blog1 = bolgRepository.findBlogById(blog_id);
        if (blog1 == null) {
            throw new ApiException("blog not found");
        }
        if (myUser.getId() == blog1.getUser().getId()) {
            bolgRepository.delete(blog1);
        }else{
            throw new ApiException("user does not have this blog");
        }
    }

    public Blog getBlogById(Integer user_id,Integer blog_id) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("user not found");
        }
        Blog blog1 = bolgRepository.findBlogById(blog_id);
        if (blog1 == null) {
            throw new ApiException("blog not found");
        }

        if (myUser.getId() == blog1.getUser().getId()) {
            return blog1;
        }else{
            throw new ApiException("user does not have this blog");
        }
    }

    public Blog getBlogByTitle(Integer user_id,String title) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("user not found");
        }
        Blog blog1 = bolgRepository.findBlogByTitle(title);
        if (blog1 == null) {
            throw new ApiException("blog not found");
        }
        if (myUser.getId() == blog1.getUser().getId()) {
            return blog1;
        }else{
            throw new ApiException("user does not have this blog");
        }
    }
}
