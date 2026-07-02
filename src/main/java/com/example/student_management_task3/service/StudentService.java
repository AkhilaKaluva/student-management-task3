package com.example.student_management_task3.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.student_management_task3.model.Student;
import com.example.student_management_task3.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepo studentRepo;
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        logger.info("Fetching student with id {}", id);
        return studentRepo.findById(id).get();
    }
    public Student addStudent(Student student){
        logger.info("Adding student {}", student.getName());
        return studentRepo.save(student);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        logger.info("Updating student with id {}", id);
        Student existingStudent=studentRepo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setAge(updatedStudent.getAge());
            logger.info("Student updated successfully with id {}", id);
            return studentRepo.save(existingStudent);
        }
        logger.warn("Student not found with id {}", id);
        return null;
    }

    public void deleteStudent(int id) {
        logger.info("Deleting student with id {}", id);
        studentRepo.deleteById(id);
    }
}
