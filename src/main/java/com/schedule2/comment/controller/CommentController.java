package com.schedule2.comment.controller;

import com.schedule2.comment.dto.CommentCreateRequest;
import com.schedule2.comment.dto.CommentCreateResponse;
import com.schedule2.comment.dto.CommentGetResponse;
import com.schedule2.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/users/{userId}/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentCreateResponse> create(
            @PathVariable Long userId, @PathVariable Long scheduleId,
            @RequestBody CommentCreateRequest request
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(userId,scheduleId, request));
    }

    @GetMapping("/users/{userId}/schedules/{scheduleId}/comments")
    public ResponseEntity<List<CommentGetResponse>> getAll(
            @PathVariable Long userId, @PathVariable Long scheduleId
    ){
        return ResponseEntity.ok(commentService.findAll(userId, scheduleId));
    }
}
