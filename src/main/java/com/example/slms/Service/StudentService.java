package com.example.slms.Service;

import com.example.slms.Entity.Student;
import java.util.List;

public interface StudentService {

    public void createStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudent(int id);
    public void updateStudent(int id, Student student);
    public void deleteStudent(int id);
}
