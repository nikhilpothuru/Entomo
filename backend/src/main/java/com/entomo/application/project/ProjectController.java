package com.entomo.application.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService; 
	
	@RequestMapping("/project")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@RequestMapping("/project/{id}")
	public Project getSingleProject(@PathVariable int id) {
		return projectService.getSingleProject(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/project")
	public void addProject(@RequestBody Project project) {
		projectService.addProject(project);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/project/{id}")
	public void updateProject(@RequestBody Project project, @PathVariable int id) {
		projectService.updateProject(project, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/project/{id}")
	public void deleteProject(@PathVariable int id) {
		projectService.deleteProject(id);
	}
		
}
