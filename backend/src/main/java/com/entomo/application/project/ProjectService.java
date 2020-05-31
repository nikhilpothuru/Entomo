package com.entomo.application.project;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entomo.application.response.ApiSuccess;
import com.entomo.application.response.DuplicateEntryException;
import com.entomo.application.response.EntityNotFoundException;
import com.entomo.application.response.NullEntryException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	Logger log = LoggerFactory.getLogger(ProjectController.class); 

	/**
	 * @name getAllProject
	 * @return Returns a list of projects 
	 */
	public ResponseEntity<Object> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		projectRepository.findAll().forEach(projects::add);
		ApiSuccess apiSuccess = new ApiSuccess();
		apiSuccess.setData(projects);
		return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
	}
	
	/**
	 * @name getSingleProject
	 * @return Returns a project 
	 */
	public ResponseEntity<Object> getSingleProject(int id) throws EntityNotFoundException{
		
		Project returnProject = projectRepository.findById(id).orElse(null);
		if(returnProject == null) {
			log.error("GET Single Project - Entry NOT FOUND");
			throw new EntityNotFoundException(Project.class, id);
		}
		ApiSuccess apiSuccess = new ApiSuccess();
		apiSuccess.setData(returnProject);
		return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus()); 
	}
	
	/**
	 * @name addProject
	 * @return Doesn't return a value
	 */
	public ResponseEntity<Object> addProject(Project project) throws Exception{
		try {
			projectRepository.save(project);
			ApiSuccess apiSuccess = new ApiSuccess();
			apiSuccess.setMessage("Successfully created project");
			return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
		}
		catch(Exception e) {
			boolean nullVal = checkNullEntry(project, e);
			if(nullVal) {
				log.error("POST A Project - Null entry");
				throw new NullEntryException(Project.class, project); 
			}
			log.error("POST A Project - Duplicate entry");
			throw new DuplicateEntryException(Project.class);  
		}
	}
	
	/**
	 * @name updateProject
	 * @return Doesn't return a value
	 */
	public ResponseEntity<Object> updateProject(Project project, int id) throws Exception{
		/*boolean allValuesAdded = checkNullEntry(project);
		if(!allValuesAdded) {
			log.error("PUT A Project - All the required fields are not entered in the form");
			throw new NullEntryException(Project.class, project); 
		}*/
		try {
			Project returnProject = projectRepository.findById(id).orElse(null);
			if(returnProject == null) {
				log.error("PUT A Project - Entry NOT FOUND");
				throw new EntityNotFoundException(Project.class, id);
			}
			project.setId(id);
			projectRepository.save(project);
			ApiSuccess apiSuccess = new ApiSuccess();
			apiSuccess.setMessage("Successfully updated project");
			return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus()); 
		}
		catch(Exception e) {
			boolean nullVal = checkNullEntry(project, e);
			if(nullVal) {
				log.error("PUT A Project - Null entry");
				throw new NullEntryException(Project.class, project); 
			}
			log.error("PUT A Project - Duplicate entry");
			throw new DuplicateEntryException(Project.class);
		}
	}
	
	/**
	 * @name deleteProject
	 * @return Doesn't return a value
	 */
	public ResponseEntity<Object> deleteProject(int id) throws EntityNotFoundException{
		Project returnProject = projectRepository.findById(id).orElse(null);
		if(returnProject == null) {
			log.error("DELETE A Project - Entry NOT FOUND");
			throw new EntityNotFoundException(Project.class, id);
		}
		projectRepository.deleteById(id);
		ApiSuccess apiSuccess = new ApiSuccess();
		apiSuccess.setMessage("Successfully deleted project");
		return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
	}
	
	/**
	 * @name checkNullEntry
	 * @return Returns boolean
	 * The following method is used in: addProject, updateProject  
	 */
	private boolean checkNullEntry(Project project, Exception e) {
		boolean nullVal = (
				project.getName() == null ||
				project.getDescription() == null
				&& e.getLocalizedMessage()
				.startsWith("not-null property references a null or transient value")
			) ? true : false;
		
		return nullVal;
	}
	 
}
