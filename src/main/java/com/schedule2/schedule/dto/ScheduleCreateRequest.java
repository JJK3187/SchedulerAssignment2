package com.schedule2.schedule.dto;

import com.schedule2.user.entity.User;
import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    private User user;
    private String scheduleTitle;
    private String scheduleContent;
}
