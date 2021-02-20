package com.writing.animula.resource;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Project;
import com.writing.animula.service.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthorResource {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ApiOperation(value = "Add an Author", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Project> createAuthor(
            @ApiParam(value = "Author", required = true) @RequestBody final Author author) {
        if(author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(authorService.getAuthorByUsername(author.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        authorService.createAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Add an Author", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Project> updateAuthor(
            @ApiParam(value = "Author", required = true) @RequestBody final Author author) {
        if(author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(authorService.getAuthorByUsername(author.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        authorService.createAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/username")
    @ApiOperation(value = "Get an Author by Username", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Author> getAuthorByUsername(
            @ApiParam(value = "Username") @RequestParam(value = "username") final String username) {
        if(username.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Author author = authorService.getAuthorByUsername(username);

        if(author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.FOUND);
    }

    @GetMapping
    @ApiOperation(value = "Get an Author by Visibility", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Author>> getAuthorByVisibility(
            @ApiParam(value = "Visible") @RequestParam(value = "Visible") final Boolean visible) {
        List<Author> author = authorService.getAllVisibleAuthors(visible);

        if(author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.FOUND);
    }

}
