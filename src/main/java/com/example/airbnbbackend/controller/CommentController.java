package com.example.airbnbbackend.controller;

import com.example.airbnbbackend.model.Booking;
import com.example.airbnbbackend.model.Comment;
import com.example.airbnbbackend.service.BookingService;
import com.example.airbnbbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BookingService bookingService;

    @PostMapping("/house/comment")
    public ResponseEntity<?> comment(@RequestBody Comment comment) {
        if (!comment.getContentComment().equals("")) {
            List<Booking> booking = bookingService.findByAccount_IdAndHouse_Id(comment.getAccount().getId(), comment.getHouse().getId());
            if (booking.size() > 0) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                comment.setTimeComment(timestamp);
                commentService.save(comment);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
