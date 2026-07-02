package com.example.student_management_task3.controller;

import com.example.student_management_task3.dto.StudentDTO;
import com.example.student_management_task3.model.Student;
import com.example.student_management_task3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentservice;
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentservice.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student=studentservice.getStudentById(id);
        if(student!=null){
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/students")
   public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDTO studentDTO){
        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setCourse(studentDTO.getCourse());
        student.setAge(studentDTO.getAge());
        Student savedStudent=studentservice.addStudent(student);
        return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(

            @PathVariable Integer id,
            @Valid @RequestBody StudentDTO studentDTO){
        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setCourse(studentDTO.getCourse());
        student.setAge(studentDTO.getAge());
        Student updatedStudent=studentservice.updateStudent(id,student);
        if(updatedStudent!=null){
            return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        studentservice.deleteStudent(id);
        return new ResponseEntity<>("Student deleted Succesfully",HttpStatus.OK);
    }

}
