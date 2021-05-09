package com.studapp.service;

import com.studapp.dao.StudentRepository;
import com.studapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> get(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public void create(Student student) {
        studentRepository.save(student);
    }

    public boolean exists(Long id) {
        return studentRepository.existsById(id);
    }
}
