package com.writing.animula.resource;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Character;
import com.writing.animula.entity.Project;
import com.writing.animula.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
@CrossOrigin(origins = "http://localhost:8080")
public class ProjectResource {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    @ApiOperation(value = "Add a Project", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Project> createProject(
            @ApiParam(value = "Project", required = true) @RequestBody final Project project) {
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        projectService.createProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Add a Project", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Project> updateProject(
            @ApiParam(value = "Project", required = true) @RequestBody final Project project) {
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        projectService.createProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get a Project by Name", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Project>> getAllProjects(
            @ApiParam(value = "Visible", required = true) @RequestParam(value = "Visible") final Boolean visible) {
        List<Project> projects = projectService.getAllVisibleProjects(visible);

        if(projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.FOUND);
    }

    @GetMapping(path = "/author")
    @ApiOperation(value = "Get a Project by Author", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Project>> getProjectsByAuthor(
            @ApiParam(value = "Author", required = true) @RequestParam(value = "Author") final Author author) {
        List<Project> projects;

        if(author.getUsername().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            projects = projectService.getProjectsByAuthor(author);
        }

        if(projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.FOUND);
    }

    @GetMapping(path = "greater")
    @ApiOperation(value = "Get a Project by multiple filters", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Project>> getFilteredProjectsWithWordCountGreaterThanEquals(
            @ApiParam(value = "Name") @RequestParam(value = "name") final String name,
            @ApiParam(value = "Author") @RequestParam(value = "Author") final Author author,
            @ApiParam(value = "Visible") @RequestParam(value = "Visible") final Boolean visible,
            @ApiParam(value = "Wordcount") @RequestParam(value = "Wordcount") final Long wordcount,
            @ApiParam(value = "Characters") @RequestParam(value = "Characters") final Collection<List<Character>> characters,
            @ApiParam(value = "Activity") @RequestParam(value = "Activity") final Collection<String> activity) {
        List<Project> projects = projectService.getFilteredProjectsWithWordCountGreaterThan(name, author, visible, wordcount, characters, activity);

        if(projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.FOUND);
    }

    @GetMapping(path = "lesser")
    @ApiOperation(value = "Get a Project by multiple filters", response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<Project>> getFilteredProjectsWithWordCountLessThanEquals(
            @ApiParam(value = "Name") @RequestParam(value = "name") final String name,
            @ApiParam(value = "Author") @RequestParam(value = "Author") final Author author,
            @ApiParam(value = "Visible") @RequestParam(value = "Visible") final Boolean visible,
            @ApiParam(value = "Wordcount") @RequestParam(value = "Wordcount") final Long wordcount,
            @ApiParam(value = "Characters") @RequestParam(value = "Characters") final Collection<List<Character>> characters,
            @ApiParam(value = "Activity") @RequestParam(value = "Activity") final Collection<String> activity) {
        List<Project> projects = projectService.getFilteredProjectsWithWordCountLesserThan(name, author, visible, wordcount, characters, activity);

        if(projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.FOUND);
    }

}
