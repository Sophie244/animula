package com.writing.animula.service;


import com.writing.animula.entity.Author;
import com.writing.animula.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    /**
     *
     * @param author
     */
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    /**
     *
     * @param visible
     * @return
     */
    public List<Author> getAllVisibleAuthors(Boolean visible) { return authorRepository.findAuthorsByVisible(visible); }

    /**
     *
     * @param username
     * @return
     */
    public Author getAuthorByUsername(String username) { return authorRepository.findAuthorByUsername(username); }

}
