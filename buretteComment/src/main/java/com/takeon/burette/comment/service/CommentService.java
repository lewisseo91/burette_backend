package com.takeon.burette.comment.service;

import com.takeon.burette.comment.domain.Comment;
import com.takeon.burette.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment findById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(IllegalArgumentException::new);
    }
}
