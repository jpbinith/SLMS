package com.example.slms.Service.Implementation;

import com.example.slms.Repository.StudentRepository;
import com.example.slms.Service.StudentService;
import com.example.slms.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepo.findAll().forEach(students::add);
//        List<Student> students = studentRepo.findAll();
        return students;
    }

    public void createStudent(Student student){
        studentRepo.save(student);
    }
    public Student getStudent(int id){
        Optional<Student> studentOpl = studentRepo.findById(id);
        if(studentOpl.isPresent()){
            return studentOpl.get();
        }else{
            return null;
        }
    }

    public void updateStudent(int id, Student student){
        studentRepo.save(student);
    }

    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }

}
