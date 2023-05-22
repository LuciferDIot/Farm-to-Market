package com.hcl.project;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {
	
	static Logger lg = Logger.getLogger(ProjectApplication.class.getName());
	public static void main(String[] args) {
		
		SpringApplication.run(ProjectApplication.class, args);
		lg.info("Project Running");
	}

}
