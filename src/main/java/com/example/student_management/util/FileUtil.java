package com.example.student_management.util;

import com.example.student_management.model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    private static final String FILE_NAME = "students.dat";

    // SAVE (Serialization)
    public static void save(ArrayList<Student> students) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            out.writeObject(students);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOAD (Deserialization)
    public static ArrayList<Student> load() {
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (ArrayList<Student>) in.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}