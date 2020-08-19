package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> findByHouse_Id(Long id);
}
