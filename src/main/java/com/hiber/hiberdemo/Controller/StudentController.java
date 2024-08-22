package com.hiber.hiberdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.hiber.hiberdemo.Entities.Student;
import com.hiber.hiberdemo.Repository.StudentRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

    @Autowired
    private StudentRepo std;

    @GetMapping("/allstudents")
    public List<Student> getAllStudents() {
        return std.findAll();
    }

    @GetMapping("/students/{sid}")
    public Student getStudentById(@PathVariable Long sid) {
        return std.findById(sid).get();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return std.save(student);
    }

    @PutMapping("/update/{sid}")
    public Student updateStudent(@PathVariable long sid, @RequestBody Student student) {
        Student existingUser = std.findById(sid).get();
        existingUser.setName(student.getName());
        existingUser.setFees(student.getFees());
        return std.save(existingUser);
    }

    @DeleteMapping("/delete/{sid}")
    public String deleteStudent(@PathVariable long sid) {
        std.findById(sid).get();
        std.deleteById(sid);
        return "Student deleted successfully";
    }

}
