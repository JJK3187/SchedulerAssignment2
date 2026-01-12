package com.schedule2.comment.entity;

import com.schedule2.schedule.entity.BaseEntity;
import com.schedule2.schedule.entity.Schedule;
import com.schedule2.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    public Comment(User user, Schedule schedule, String scheduleContent) {
        this.user = user;
        this.schedule = schedule;
        this.text = scheduleContent;
    }

}
