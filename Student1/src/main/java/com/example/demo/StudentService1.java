package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService1 {
    @Autowired
    private StudentRepository1 studentRepository;

    public List<Student1> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student1> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student1 createStudent(Student1 student) {
        return studentRepository.save(student);
    }

    public Optional<Student1> updateStudent(Long id, Student1 updatedStudent) {
        Optional<Student1> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student1 studentToUpdate = existingStudent.get();
            studentToUpdate.setName(updatedStudent.getName());
            // Update other properties as needed
            return Optional.of(studentRepository.save(studentToUpdate));
        }
        return Optional.empty();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
