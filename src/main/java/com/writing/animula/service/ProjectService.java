package com.writing.animula.service;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Character;
import com.writing.animula.entity.Project;
import com.writing.animula.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     *
     * @param project
     */
    public void createProject(Project project) { projectRepository.save(project); }

    /**
     *
     * @param name
     * @return
     */
    public List<Project> getProjectsByName(String name) { return projectRepository.findProjectsByName(name); }

    /**
     *
     * @param visible
     * @return
     */
    public List<Project> getAllVisibleProjects(Boolean visible) { return projectRepository.findProjectsByVisible(visible); }

    /**
     *
     * @param activity
     * @return
     */
    public List<Project> getProjectsByActivity(String activity) {
        return projectRepository.findProjectsByActivity(activity);
    }

    /**
     *
     * @param wordcount
     * @return
     */
    public List<Project> getProjectsByWordcountGreaterThanEqual(Long wordcount) {
        return projectRepository.findProjectsByWordcountIsGreaterThanEqual(wordcount);
    }

    /**
     *
     * @param wordcount
     * @return
     */
    public List<Project> getProjectsByWordcountLessThanEqual(Long wordcount) {
        return projectRepository.findProjectsByWordcountIsLessThanEqual(wordcount);
    }

    /**
     *
     * @param author
     * @return
     */
    public List<Project> getProjectsByAuthor(Author author) {
        return projectRepository.findProjectsByAuthor(author);
    }

    /**
     *
     * @param published
     * @return
     */
    public List<Project> getProjectsByPublished(Boolean published) {
        return projectRepository.findProjectsByPublished(published);
    }

    /**
     *
     * @param lastModified
     * @return
     */
    public List<Project> getProjectsByLastModifiedAfter(LocalDate lastModified) {
        return projectRepository.findProjectsByLastModifiedAfter(lastModified);
    }

    /**
     *
     * @param name
     * @param author
     * @param wordcount
     * @param characters
     * @param activity
     * @return
     */
    public List<Project> getFilteredProjectsWithWordCountGreaterThan(String name, Author author, Boolean visible, Long wordcount, Collection<List<Character>> characters, Collection<String> activity) {
        return projectRepository.findProjectsByNameAndAuthorAndVisibleAndWordcountIsGreaterThanEqualAndCharactersInAndActivityIn(name, author, visible, wordcount, characters, activity);
    }

    /**
     *
     * @param name
     * @param author
     * @param wordcount
     * @param characters
     * @param activity
     * @return
     */
    public List<Project> getFilteredProjectsWithWordCountLesserThan(String name, Author author, Boolean visible, Long wordcount, Collection<List<Character>> characters, Collection<String> activity) {
        return projectRepository.findProjectsByNameAndAuthorAndVisibleAndWordcountIsLessThanEqualAndCharactersInAndActivityIn(name, author, visible, wordcount, characters, activity);
    }
}
