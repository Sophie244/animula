package com.writing.animula.service;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Comment;
import com.writing.animula.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    /**
     *
     * @param comment
     */
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     *
     * @param author
     * @return
     */
    public List<Comment> getCommentsByAuthor(Author author) {
        return commentRepository.findCommentsByAuthor(author);
    }

    /**
     *
     * @param rating
     * @return
     */
    public List<Comment> getCommentsByRating(Long rating) {
        return commentRepository.findCommentsByRatingOrderBySubmittedAsc(rating);
    }
}
