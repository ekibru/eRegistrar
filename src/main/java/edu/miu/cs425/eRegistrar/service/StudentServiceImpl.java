package edu.miu.cs425.eRegistrar.service;


import edu.miu.cs425.eRegistrar.enitity.Course;
import edu.miu.cs425.eRegistrar.enitity.Student;
import edu.miu.cs425.eRegistrar.repository.CourseRepository;
import edu.miu.cs425.eRegistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        if (student.getCourses()!= null) {

            List<Course> managedCourse = new ArrayList<>();
            student.setCourses(managedCourse);
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deletePublisherById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getReferenceById(studentId);
    }


}
