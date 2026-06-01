package com.example.student_management.service;

import com.example.student_management.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final ArrayList<Student> students = new ArrayList<>();
    private final Stack<Student> stack = new Stack<>();

    // ADD STUDENT
    public String addStudent(Student s) {
        students.add(s);

        stack.push(s);

        // keep only last 3 students
        if (stack.size() > 3) {
            stack.remove(0);
        }

        return "Student added";
    }

    // VIEW ALL (Iterator required)
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    // SORT BY ID (Comparable)
    public List<Student> sortById() {
        List<Student> list = new ArrayList<>(students);
        Collections.sort(list);
        return list;
    }

    // SORT BY CGPA (Comparator)
    public List<Student> sortByCgpa() {
        List<Student> list = new ArrayList<>(students);

        list.sort((a, b) ->
                Double.compare(b.getCgpa(), a.getCgpa()));

        return list;
    }

    // UNIQUE DEPARTMENTS (Set)
    public Set<String> departments() {
        Set<String> set = new HashSet<>();
        for (Student s : students) {
            set.add(s.getDepartment());
        }
        return set;
    }

    // STACK OPERATIONS
    public Stack<Student> getStack() {
        return stack;
    }

    public Student peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public Student pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public List<Student> getInternalList() {
        return students;
    }
}