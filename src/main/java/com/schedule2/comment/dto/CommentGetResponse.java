package com.schedule2.comment.dto;

import com.schedule2.schedule.entity.Schedule;
import com.schedule2.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {

    private final Long id;
    private final User user;
    private final Schedule schedule;
    private final String text;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentGetResponse(Long id, User user, Schedule schedule,String text, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.user = user;
        this.schedule = schedule;
        this.text = text;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
