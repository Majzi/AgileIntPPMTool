package io.agileintelligence.ppmtool.Services;

import io.agileintelligence.ppmtool.Domain.Project;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {



        return projectRepository.save(project);
    }
}
