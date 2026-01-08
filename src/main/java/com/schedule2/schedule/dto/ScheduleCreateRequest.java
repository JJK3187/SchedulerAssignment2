package com.schedule2.schedule.dto;

import com.schedule2.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    @NotBlank
    private User user;
    @NotBlank
    private String scheduleTitle;
    private String scheduleContent;
}
