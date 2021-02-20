package com.writing.animula.repository;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findCommentsByAuthor(@NotNull(message = "Comments Author must not be empty") Author author);

    List<Comment> findCommentsByRatingOrderBySubmittedAsc(Long rating);

}
