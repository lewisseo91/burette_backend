package com.takeon.burette.comment.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleId; // 직접 관계 고민해보기

    private String userId; // 간접

    private String content;

    private String imagePath;

    private String isDeleted;

    private LocalDateTime deletedAt;

    public void updateContent(String content) {
        this.content = content;
    }
}
