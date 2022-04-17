package com.takeon.burette.comment.service;

import com.takeon.burette.comment.domain.Comment;
import com.takeon.burette.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void addReComment(Comment parentComment, Comment comment) {
        comment.setParentId(parentComment.getId());

        commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment, String content) {
        Comment updatedComment = findById(comment.getId());
        updatedComment.updateContent(content);

        return updatedComment;
    }

    public void deleteComment(Comment comment) {
        commentRepository.deleteById(comment.getId());
    }

    public Comment findById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(IllegalArgumentException::new);
    }
}
