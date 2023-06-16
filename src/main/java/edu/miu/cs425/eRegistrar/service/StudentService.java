package edu.miu.cs425.eRegistrar.service;


import edu.miu.cs425.eRegistrar.enitity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    void deletePublisherById(Long studentId);

    Student getStudentById(Long studentId);
}