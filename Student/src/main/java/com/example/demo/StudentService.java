package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean validateStudent(Student student) {
        // Check if name is at least 5 characters long and age is at least 18
        return student.getName().length() >= 5 && student.getAge() >= 18;
    }

    public boolean validateStudentMarks(Student student) {
        return student.getMark1() >= 0 && student.getMark1() <= 100 &&
               student.getMark2() >= 0 && student.getMark2() <= 100 &&
               student.getMark3() >= 0 && student.getMark3() <= 100;
    }

    public Student createStudent(Student student) {
        if (validateStudent(student) && validateStudentMarks(student)) {
            int totalMarks = student.getMark1() + student.getMark2() + student.getMark3();
            student.setTotal(totalMarks);
            if (student.getMark1() < 40 || student.getMark2() < 40 || student.getMark3() < 40) {
                student.setResult("Fail");
            } else {
                student.setResult("Pass");
            }
            return studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student data is not valid");
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
