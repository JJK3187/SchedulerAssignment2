package com.schedule2.schedule.dto;

import com.schedule2.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    @NotBlank
    private User user;
    @NotBlank @Size(max = 30)
    private String scheduleTitle;
    @Size(max = 300)
    private String scheduleContent;
}
