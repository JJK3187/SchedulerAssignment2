package com.schedule2.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    private String userName;
    private String scheduleTitle;
    private String scheduleContent;
}
