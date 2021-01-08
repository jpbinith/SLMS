package com.example.slms.Service.Implementation;

import com.example.slms.Entity.Subject;
import com.example.slms.Repository.StudentRepository;
import com.example.slms.Repository.SubjectRepository;
import com.example.slms.Service.StudentService;
import com.example.slms.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private SubjectRepository subjectRepo;

    @Transactional
    public List<Student> getAllStudents(){
//        List<Student> students = new ArrayList<>();
//        studentRepo.findAll().forEach(students::add);
//        return students;
        return studentRepo.findAll();
    }
//    public List<Student> getAllStudents(){
//        List<Student> students = new ArrayList<>();
//        studentRepo.findAll().forEach(students::add);
//        return students;
//    }

    public void createStudent(Student student){
        studentRepo.save(student);
    }

    @Transactional
    public Student getStudent(long id){
        Optional<Student> studentOpl = studentRepo.findById(id);
        if(studentOpl.isPresent()){
            return studentOpl.get();
        }else{
            return null;
        }
    }

    public void updateStudent(long id, Student student){
        Optional<Student> studentOptional = studentRepo.findById(id);
        if(studentOptional.isPresent()){
            studentRepo.save(student);
        }
    }

    public void deleteStudent(long id){
        studentRepo.deleteById(id);
    }

    public void updateStudentSubject(long stuId, long subId){
        Optional<Student> studentOptional = studentRepo.findById(stuId);
        if (studentOptional.isPresent()){
            Optional<Subject> subjectOptional = subjectRepo.findById(subId);
            if(subjectOptional.isPresent()){
                Student student = studentOptional.get();
                Subject subject = subjectOptional.get();
                student.setSubject(subject);
                studentRepo.save(student);
            }
        }
    }
}
