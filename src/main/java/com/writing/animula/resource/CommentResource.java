package com.writing.animula.resource;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Comment;
import com.writing.animula.service.CommentService;
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
@RequestMapping(value = "/comments")
@CrossOrigin(origins = "http://localhost:8080")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation(value = "Add a Comment", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Comment> createComment(
            @ApiParam(value = "Comment", required = true) @RequestBody final Comment comment) {
        if(comment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        commentService.createComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Update a Comment", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Comment> updateComment(
            @ApiParam(value = "Comment", required = true) @RequestBody final Comment comment) {
        if(comment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        commentService.createComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/author")
    @ApiOperation(value = "Get Comments by Author", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Comment>> getCommentsByAuthor(
            @ApiParam(value = "Author", required = true) @RequestParam(value = "Author") final Author author) {
        if(author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Comment> comments = commentService.getCommentsByAuthor(author);

        if(comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.FOUND);
    }

    @GetMapping(path = "/{rating}/rating")
    @ApiOperation(value = "Get Comments by Rating", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Comment>> getCommentsByRating(
            @ApiParam(value = "Rating", required = true) @PathVariable(value = "rating") final Long rating) {
        List<Comment> comments = commentService.getCommentsByRating(rating);

        if(comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.FOUND);
    }
}
