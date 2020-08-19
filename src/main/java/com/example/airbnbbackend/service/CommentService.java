package com.example.airbnbbackend.service;

import com.example.airbnbbackend.model.Comment;
import org.springframework.stereotype.Service;

public interface CommentService {
    void save(Comment comment);

}
