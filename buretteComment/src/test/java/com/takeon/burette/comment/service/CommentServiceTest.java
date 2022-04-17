package com.takeon.burette.comment.service;

import com.takeon.burette.AcceptanceTest;
import com.takeon.burette.comment.domain.Comment;
import com.takeon.burette.comment.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("댓글 서비스 단위 테스트")
class CommentServiceTest extends AcceptanceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("댓글을 생성할 수 있다.")
    @Test
    void createComment() {
        Comment comment = new Comment();
        commentService.addComment(comment);

        assertAll(
                () -> assertThat(comment.getId()).isNotNull()
        );
    }

    @DisplayName("댓글을 수정할 수 있다.")
    @Test
    void modifyComment() {
        Comment comment = new Comment();
        Comment savedComment = commentRepository.save(comment);
        String content = "수정 테스트";
        Comment updatedComment = commentService.updateComment(savedComment, content);

        assertAll(
                () -> assertThat(comment.getId()).isNotNull(),
                () -> assertThat(updatedComment.getContent()).isEqualTo(content)
        );
    }

    @DisplayName("댓글을 삭제할 수 있다.")
    @Test
    void deleteComment() {
        Comment comment = new Comment();
        Comment savedComment = commentRepository.save(comment);
        commentService.deleteComment(savedComment);

        assertAll(
                () -> assertThat(commentRepository.findAll().size() == 0)
        );
    }

    @DisplayName("대댓글을 생성할 수 있다.")
    @Test
    void createReComment() {
        Comment comment = new Comment();
        Comment reComment = new Comment();
        commentService.addReComment(comment, reComment);

        assertAll(
                () -> assertThat(reComment.getParentId()).isEqualTo(comment.getId())
        );
    }
}