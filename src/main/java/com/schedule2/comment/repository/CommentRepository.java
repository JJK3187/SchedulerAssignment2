package com.schedule2.comment.repository;

import com.schedule2.comment.entity.Comment;
import com.schedule2.schedule.entity.Schedule;
import com.schedule2.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByIdBetween(User user, Schedule schedule);
}