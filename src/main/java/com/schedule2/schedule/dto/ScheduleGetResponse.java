package com.schedule2.schedule.dto;

import com.schedule2.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleGetResponse {

    private final Long id;
    private final User user;
    private final String scheduleTitle;
    private final String scheduleContent;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleGetResponse(Long id, User user, String scheduleTitle, String scheduleContent, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.user = user;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContent = scheduleContent;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
