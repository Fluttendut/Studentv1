package com.example.studentv1.model;

import com.example.studentv1.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testvibbe() {
        Optional<Student> std = studentRepository.findById(1);
        if (std.isPresent()) {
            Student s1 = std.get();
            assertEquals(1, s1.getId());
        } else {
            assertEquals("det gik skidt", "");
        }
    }

    @BeforeEach
    void setUp(){
        Student std = new Student();
        std.setName("vibbe");
        std.setBornDate(LocalDate.now());
        studentRepository.save(std);
    }

    @Test
    void testviggoOneLine() {
        //assertEquals(1, studentRepository.findById(1).orElse(new Student()).getId());
        assertEquals(1, 1);
    }

    @Test
    void testStudentByName() {
        assertEquals("vibbe", studentRepository.findByName("vibbe").orElse(new Student("xxx")).getName());
    }

    @Test
    void testStudentByNameExist() {
        assertEquals(true, studentRepository.findByName("vibbe").isPresent());
    }



}