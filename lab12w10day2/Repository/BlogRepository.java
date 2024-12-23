package com.example.lab12w10day2.Repository;

import com.example.lab12w10day2.Model.Blog;
import com.example.lab12w10day2.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);
    Blog findBlogByTitle(String title);
    List<Blog> findAllByUser(MyUser myUser);

}
