package com.entomo.application.project;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entomo.application.exception.DuplicateEntryException;
import com.entomo.application.exception.EntityNotFoundException;
import com.entomo.application.exception.NullEntryException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	/**
	 * @name getAllProject
	 * @return Returns a list of projects 
	 */
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		projectRepository.findAll().forEach(projects::add);
		return projects;
	}
	
	/**
	 * @name getSingleProject
	 * @return Returns a project 
	 */
	public Project getSingleProject(int id) throws EntityNotFoundException{
		
		Project returnProject = projectRepository.findById(id).orElse(null);
		if(returnProject == null) {
			throw new EntityNotFoundException(Project.class, id);
		}
		return returnProject;  
	}
	
	/**
	 * @name addProject
	 * @return Doesn't return a value
	 */
	public void addProject(Project project) throws Exception{
		try {
			projectRepository.save(project);
		}
		catch(Exception e) {
			String eMessage = e.getLocalizedMessage();
			boolean nullVal = eMessage.startsWith("not-null property references a null or transient value");
			if(nullVal) {
				throw new NullEntryException(Project.class, project); 
			}
			throw new DuplicateEntryException(Project.class);  
		}
	}
	
	/**
	 * @name updateProject
	 * @return Doesn't return a value
	 */
	public void updateProject(Project project, int id) throws EntityNotFoundException{
		Project returnProject = projectRepository.findById(id).orElse(null);
		if(returnProject == null) {
			throw new EntityNotFoundException(Project.class, id);
		}
		project.setId(id);
		projectRepository.save(project); 
	}
	
	/**
	 * @name deleteProject
	 * @return Doesn't return a value
	 */
	public void deleteProject(int id) throws EntityNotFoundException{
		Project returnProject = projectRepository.findById(id).orElse(null);
		if(returnProject == null) {
			throw new EntityNotFoundException(Project.class, id);
		}
		projectRepository.deleteById(id);
	}
	 
}
