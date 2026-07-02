package com.example.student_management_task3;
import com.example.student_management_task3.model.Student;
import com.example.student_management_task3.repo.StudentRepo;
import com.example.student_management_task3.service.StudentService;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetAllStudents() {

        Student s1 = new Student();
        s1.setName("Akhila");

        Student s2 = new Student();
        s2.setName("Rahul");

        List<Student> students = Arrays.asList(s1, s2);

        when(studentRepo.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Akhila", result.get(0).getName());


        verify(studentRepo).findAll();
    }
    @Test
    void testGetStudentById() {

        Student student = new Student();
        student.setId(1L);
        student.setName("Akhila");
        student.setEmail("akhila@gmail.com");

        when(studentRepo.findById(1))
                .thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Akhila", result.getName());

        verify(studentRepo).findById(1);
    }
    @Test
    void testAddStudent() {

        Student student = new Student();
        student.setId(1L);
        student.setName("Akhila");
        student.setEmail("akhila@gmail.com");

        when(studentRepo.save(student)).thenReturn(student);

        Student result = studentService.addStudent(student);

        assertNotNull(result);
        assertEquals("Akhila", result.getName());
        assertEquals("akhila@gmail.com", result.getEmail());

        verify(studentRepo).save(student);
    }
    @Test
    void testUpdateStudent() {

        Student existingStudent = new Student();
        existingStudent.setId(1L);
        existingStudent.setName("Old Name");
        existingStudent.setEmail("old@gmail.com");
        existingStudent.setCourse("CSE");
        existingStudent.setAge(20);

        Student updatedStudent = new Student();
        updatedStudent.setName("Akhila");
        updatedStudent.setEmail("akhila@gmail.com");
        updatedStudent.setCourse("IT");
        updatedStudent.setAge(21);

        when(studentRepo.findById(1))
                .thenReturn(Optional.of(existingStudent));

        when(studentRepo.save(existingStudent))
                .thenReturn(existingStudent);

        Student result = studentService.updateStudent(1, updatedStudent);

        assertNotNull(result);
        assertEquals("Akhila", result.getName());
        assertEquals("akhila@gmail.com", result.getEmail());
        assertEquals("IT", result.getCourse());
        assertEquals(21, result.getAge());

        verify(studentRepo).findById(1);
        verify(studentRepo).save(existingStudent);
    }
    @Test
    void testDeleteStudent() {

        studentService.deleteStudent(1);

        verify(studentRepo).deleteById(1);
    }
}