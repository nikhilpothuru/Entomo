package com.entomo.application.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
