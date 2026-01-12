package com.schedule2.comment.dto;

import com.schedule2.schedule.entity.Schedule;
import com.schedule2.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentCreateResponse {

    private final Long id;
    private final String text;
    private final User user;
    private final Schedule schedule;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentCreateResponse(Long id, String text, User user, Schedule schedule, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.schedule = schedule;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }
}
