package edu.miu.cs425.eRegistrar.controller;

import edu.miu.cs425.eRegistrar.enitity.Student;
import edu.miu.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/","/eRegistrar","/eRegistrar/home"})
    public String displayHomePage(){
        return "home";
    }
    @GetMapping(value = {"/eRegistrar/student-list"})
    public String displayStudentList(Model model){
        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students",students);
        return "studentlist";
    }
    @GetMapping(value = {"/eRegistrar/student-list/new"})
    public String displayStudentForm(Model model){

          Student student = new Student();
        model.addAttribute("student", student);

        return "new";
    }
    @PostMapping(value = {"/eRegistrar/student-list"})
    public String addStudent(@ModelAttribute("students") Student student ){


        studentService.saveStudent(student);

        return "redirect:/eRegistrar/student-list";
    }
    @GetMapping("/eRegistrar/student-list/{studentId}/delete")
    public String deletePublisher(@PathVariable Long studentId) {
        studentService.deletePublisherById(studentId);
        return "redirect:/eRegistrar/student-list";
    }
    @GetMapping(value = {"/eRegistrar/student-list/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "edit";
    }
    @PostMapping(value = {"/eRegistrar/student-list/{studentId}"})
    public String updateStudent(@PathVariable Long studentId, @ModelAttribute("student") Student student, Model model) {
        Student updatedStudent = studentService.getStudentById(studentId);
        updatedStudent.setStudentId(student.getStudentId());
        updatedStudent.setStudentNumber(student.getStudentNumber());
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setMiddleName(student.getMiddleName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setCgpa(student.getCgpa());
        updatedStudent.setDateOfEnrollment(student.getDateOfEnrollment());

        studentService.saveStudent(updatedStudent);

        return "redirect:/eRegistrar/student-list";
    }
}
