package com.schedule2.schedule.repository;

import com.schedule2.schedule.entity.Schedule;
import com.schedule2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUser(User user);
}
