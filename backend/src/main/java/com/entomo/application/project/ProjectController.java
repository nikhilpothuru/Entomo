package com.entomo.application.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService; 
	
	Logger log = LoggerFactory.getLogger(ProjectController.class); 
	
	@RequestMapping("/project")
	public ResponseEntity<Object> getAllProjects() {
		log.info("GET All Projects");
		return projectService.getAllProjects();
	}
	
	@RequestMapping("/project/{id}")
	public ResponseEntity<Object> getSingleProject(@PathVariable int id) {
		log.info("GET Single Project");
		return projectService.getSingleProject(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/project")
	public ResponseEntity<Object> addProject(@RequestBody Project project) throws Exception {
		log.info("POST A Project");
		return projectService.addProject(project);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/project/{id}")
	public ResponseEntity<Object> updateProject(@RequestBody Project project, @PathVariable int id)
			throws Exception
	{
		log.info("PUT A Project");
		return projectService.updateProject(project, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/project/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable int id) {
		log.info("DELETE A Project");
		return projectService.deleteProject(id);
	}
		
}
