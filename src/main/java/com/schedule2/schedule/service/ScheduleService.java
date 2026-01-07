package com.schedule2.schedule.service;

import com.schedule2.schedule.dto.*;
import com.schedule2.schedule.entity.Schedule;
import com.schedule2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleCreateResponse save(ScheduleCreateRequest request) {
        Schedule schedule = new Schedule(
                request.getUserName(),
                request.getScheduleTitle(),
                request.getScheduleContent()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleCreateResponse(
                savedSchedule.getId(),
                savedSchedule.getUserName(),
                savedSchedule.getScheduleTitle(),
                savedSchedule.getScheduleContent(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleGetResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleGetResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleGetResponse dto = new ScheduleGetResponse(
                    schedule.getId(),
                    schedule.getUserName(),
                    schedule.getScheduleTitle(),
                    schedule.getScheduleContent(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleGetResponse findOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new ScheduleGetResponse(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getScheduleTitle(),
                schedule.getScheduleContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public ScheduleUpdateResponse update(Long scheduleId, ScheduleUpdateRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        schedule.update(
                request.getScheduleTitle(),
                request.getScheduleContent()
        );
        return new ScheduleUpdateResponse(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getScheduleTitle(),
                schedule.getScheduleContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long scheduleId) {
        boolean exists = scheduleRepository.existsById(scheduleId);
        if (!exists){
            throw new IllegalStateException("없는 일정입니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
