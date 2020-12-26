package com.example.slms.Service;

import com.example.slms.Entity.Student;
import java.util.List;

public interface StudentService {

    void createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudent(long id);
    void updateStudent(int id, Student student);
    void deleteStudent(long id);
    void updateStudentSubject(long stuId, long subId);
}
