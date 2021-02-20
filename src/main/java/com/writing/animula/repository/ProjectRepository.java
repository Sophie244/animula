package com.writing.animula.repository;

import com.writing.animula.entity.Author;
import com.writing.animula.entity.Character;
import com.writing.animula.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

    List<Project> findProjectsByName(String name);

    List<Project> findProjectsByVisible(Boolean visible);

    List<Project> findProjectsByActivity(String activity);

    List<Project> findProjectsByAuthor(Author author);

    List<Project> findProjectsByPublished(Boolean published);

    List<Project> findProjectsByLastModifiedAfter(LocalDate lastModified);

    List<Project> findProjectsByWordcountIsGreaterThanEqual(Long wordcount);

    List<Project> findProjectsByWordcountIsLessThanEqual(Long wordcount);

    List<Project> findProjectsByNameAndAuthorAndVisibleAndWordcountIsGreaterThanEqualAndCharactersInAndActivityIn(@NotNull(message = "Projects name must not be empty") String name, @NotNull(message = "Projects author must not be empty") Author author, Boolean visible, Long wordcount, Collection<List<Character>> characters, Collection<String> activity);

    List<Project> findProjectsByNameAndAuthorAndVisibleAndWordcountIsLessThanEqualAndCharactersInAndActivityIn(@NotNull(message = "Projects name must not be empty") String name, @NotNull(message = "Projects author must not be empty") Author author, Boolean visible, Long wordcount, Collection<List<Character>> characters, Collection<String> activity);

}
