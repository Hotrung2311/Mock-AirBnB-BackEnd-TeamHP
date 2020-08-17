package com.example.airbnbbackend.service.impl;

import com.example.airbnbbackend.model.Comment;
import com.example.airbnbbackend.repositories.CommentRepository;
import com.example.airbnbbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
