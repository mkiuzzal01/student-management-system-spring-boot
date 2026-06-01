package com.example.student_management.controller;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import com.example.student_management.util.FileUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ADD
    @PostMapping("/add")
    public String add(@RequestBody Student s) {
        return service.addStudent(s);
    }

    // ALL
    @GetMapping("/all")
    public List<Student> all() {
        return service.getAll();
    }

    // SORT ID
    @GetMapping("/sort/id")
    public List<Student> sortId() {
        return service.sortById();
    }

    // SORT CGPA
    @GetMapping("/sort/cgpa")
    public List<Student> sortCgpa() {
        return service.sortByCgpa();
    }

    // UNIQUE DEPARTMENTS
    @GetMapping("/departments")
    public Set<String> departments() {
        return service.departments();
    }

    // STACK
    @GetMapping("/stack")
    public Stack<Student> stack() {
        return service.getStack();
    }

    @GetMapping("/stack/peek")
    public Student peek() {
        return service.peek();
    }

    @GetMapping("/stack/pop")
    public Student pop() {
        return service.pop();
    }

    // SAVE FILE
    @PostMapping("/save")
    public String save() {
        FileUtil.save(new ArrayList<>(service.getInternalList()));
        return "Saved to file";
    }

    // LOAD FILE
    @GetMapping("/load")
    public ArrayList<Student> load() {
        return FileUtil.load();
    }
}