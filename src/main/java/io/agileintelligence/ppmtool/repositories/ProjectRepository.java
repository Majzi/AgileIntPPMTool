package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.Domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);

    Project findByProjectIdentifier(String projectId);

    List<Project> findAll();

    Project removeByProjectIdentifier(String projectId);
}
