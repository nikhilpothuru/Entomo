package com.entomo.application.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Project getSingleProject(int id){
		return projectRepository.findById(id).orElse(null);  
	}
	
	/**
	 * @name addProject
	 * @return Doesn't return a value
	 */
	public void addProject(Project project){
		projectRepository.save(project); 
	}
	
	
	 
}
