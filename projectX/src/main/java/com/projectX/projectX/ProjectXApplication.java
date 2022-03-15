package com.projectX.projectX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ProjectXApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ProjectXApplication.class, args);
	}

}
