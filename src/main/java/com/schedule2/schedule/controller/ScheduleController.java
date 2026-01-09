package com.schedule2.schedule.controller;

import com.schedule2.schedule.dto.*;
import com.schedule2.schedule.service.ScheduleService;
import com.schedule2.user.dto.SessionUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/users/{userId}schedules")
    public ResponseEntity<ScheduleCreateResponse> createSchedule(
            @PathVariable Long userId,
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @Valid @RequestBody ScheduleCreateRequest request
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(sessionUser, userId, request));
    }

    @GetMapping("/users/{userId}/schedules")
    public ResponseEntity<List<ScheduleGetResponse>> getSchedules(
            @PathVariable Long userId
    ){
        return ResponseEntity.ok(scheduleService.findAll(userId));
    }

    @GetMapping("/users/{userId}/schedules/{scheduleId}")
    public ResponseEntity<ScheduleGetResponse> getSchedule(
            @PathVariable Long scheduleId
    ){
        return ResponseEntity.ok(scheduleService.findOne(scheduleId));
    }

    @PutMapping("/users/{userId}/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @Valid @RequestBody ScheduleUpdateRequest request
    ){
        return ResponseEntity.ok(scheduleService.update(scheduleId, request));
    }

    @DeleteMapping("/users/{userId}/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long scheduleId
    ){
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
