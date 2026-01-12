package com.schedule2.comment.service;

import com.schedule2.comment.dto.CommentCreateRequest;
import com.schedule2.comment.dto.CommentCreateResponse;
import com.schedule2.comment.dto.CommentGetResponse;
import com.schedule2.comment.entity.Comment;
import com.schedule2.comment.repository.CommentRepository;
import com.schedule2.schedule.entity.Schedule;
import com.schedule2.schedule.repository.ScheduleRepository;
import com.schedule2.user.entity.User;
import com.schedule2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentCreateResponse save(Long userId, Long scheduleId, CommentCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        Comment comment = new Comment(user, schedule, request.getText());
        Comment savedComment = commentRepository.save(comment);

        return new CommentCreateResponse(
                savedComment.getId(),
                savedComment.getText(),
                savedComment.getUser(),
                savedComment.getSchedule(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<CommentGetResponse> findAll(Long userId, Long scheduleId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        List<Comment> comments = commentRepository.findByIdBetween(user, schedule);
        List<CommentGetResponse> dtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentGetResponse dto = new CommentGetResponse(
                    comment.getId(),
                    comment.getUser(),
                    comment.getSchedule(),
                    comment.getText(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
