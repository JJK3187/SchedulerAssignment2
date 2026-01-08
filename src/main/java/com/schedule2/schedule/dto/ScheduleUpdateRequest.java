package com.schedule2.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {

    @NotBlank
    private String scheduleTitle;
    private String scheduleContent;
}
