package io.agileintelligence.ppmtool.Services;

import io.agileintelligence.ppmtool.Domain.Project;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        try {
            Project findProject = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
            if (findProject != null) {
                project.setId(findProject.getId());
            }
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() +  " already exist");
        }
    }

    public Project findProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project not found");
        }
        return project;
    }

    public List<Project> findAllProjects() {
        List<Project> projects = projectRepository.findAll();
        if (projects.size() > 0) {
            return projects;
        }
        return null;
    }

    public boolean deleteProject(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project != null) {
            projectRepository.delete(project);
            return true;
        }
        return false;
    }
}
