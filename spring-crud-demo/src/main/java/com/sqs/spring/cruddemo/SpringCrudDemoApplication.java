package com.sqs.spring.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sqs.spring.cruddemo.dao.StudentDAO;
import com.sqs.spring.cruddemo.entity.Student;

@SpringBootApplication
public class SpringCrudDemoApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringCrudDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
	return runner -> {
	    // createStudent(studentDAO);

	    createMultipleStudents(studentDAO);
	};
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
	System.out.println("Creating 3 new students objects ...");
	Student tempStudent1 = new Student("John", "Doe", "john@sqs.com");
	Student tempStudent2 = new Student("Mary", "Public", "mary@sqs.com");
	Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@sqs.com");

	System.out.println("Saving the students ...");
	studentDAO.save(tempStudent1);
	studentDAO.save(tempStudent2);
	studentDAO.save(tempStudent3);
    }

    @SuppressWarnings("unused")
    private void createStudent(StudentDAO studentDAO) {

	System.out.println("Creating new student object ...");
	Student tempStudent = new Student("Paul", "Doe", "paul@sqs.com");

	System.out.println("Saving the student ...");
	studentDAO.save(tempStudent);

	System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
