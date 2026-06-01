package com.example.student_management.model;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double cgpa;

    public Student() {
    }

    public Student(int id, String name, String department, double cgpa) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    // Comparable → sort by ID
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + cgpa;
    }
}