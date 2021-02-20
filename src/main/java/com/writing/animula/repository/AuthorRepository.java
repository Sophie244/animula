package com.writing.animula.repository;

import com.writing.animula.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findAuthorByUsername(String username);

    List<Author> findAuthorsByVisible(Boolean visible);
}
