package com.sqs.spring.cruddemo;

import java.util.List;

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

	    // readStudent(studentDAO);

	    // queryForStudents(studentDAO);

	    // queryForStudentsByLastName(studentDAO);

	    // updateStudent(studentDAO);

	    // deleteStudent(studentDAO);

	    // deleteAllStudents(studentDAO);
	};
    }

    @SuppressWarnings("unused")
    private void deleteAllStudents(StudentDAO studentDAO) {

	System.out.println("Deleting all students");
	int numRowsDeleted = studentDAO.deleteAll();
	System.out.println("Deleted row count: " + numRowsDeleted);
    }

    @SuppressWarnings("unused")
    private void deleteStudent(StudentDAO studentDAO) {

	int studentId = 3;
	System.out.println("Deleting student id: " + studentId);
	studentDAO.delete(studentId);
    }

    @SuppressWarnings("unused")
    private void updateStudent(StudentDAO studentDAO) {

	int studentId = 1;
	System.out.println("Getting student with id: " + studentId);
	Student myStudent = studentDAO.findById(studentId);
	System.out.println(myStudent);

	System.out.println("Updating student ...");
	// myStudent.setFirstName("Scooby");
	myStudent.setFirstName("John");
	studentDAO.update(myStudent);

	System.out.println("Updated student: " + myStudent);
    }

    @SuppressWarnings("unused")
    private void queryForStudentsByLastName(StudentDAO studentDAO) {

	List<Student> theStudents = studentDAO.findByLastName("Duck");

	for (Student tempStudent : theStudents) {
	    System.out.println(tempStudent);
	}
    }

    @SuppressWarnings("unused")
    private void queryForStudents(StudentDAO studentDAO) {

	List<Student> theStudents = studentDAO.findAll();

	for (Student tempStudent : theStudents) {
	    System.out.println(tempStudent);
	}
    }

    @SuppressWarnings("unused")
    private void readStudent(StudentDAO studentDAO) {

	System.out.println("Creating new student object ...");
	Student tempStudent = new Student("Daffy", "Duck", "daffy@sqs.com");

	System.out.println("Saving the student ...");
	studentDAO.save(tempStudent);

	int theId = tempStudent.getId();
	System.out.println("Saved student. Generated id: " + theId);

	System.out.println("Retrievind student with id: " + theId);
	Student myStudent = studentDAO.findById(theId);

	System.out.println("Found the student: " + myStudent);
    }

    @SuppressWarnings("unused")
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
