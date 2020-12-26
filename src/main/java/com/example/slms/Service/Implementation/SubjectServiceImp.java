package com.example.slms.Service.Implementation;

import com.example.slms.Entity.Student;
import com.example.slms.Entity.Subject;
import com.example.slms.Repository.StudentRepository;
import com.example.slms.Repository.SubjectRepository;
import com.example.slms.Service.StudentService;
import com.example.slms.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImp implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepo;

    public List<Subject> getAllSubjects(){
        List<Subject> subject = new ArrayList<>();
        subjectRepo.findAll().forEach(subject::add);
        return subject;
    }

    public void createSubject(Subject subject){
        subjectRepo.save(subject);
    }

    public Subject getSubject(long id){
        Optional<Subject> subjectOptional = subjectRepo.findById(id);
        if (subjectOptional.isPresent()){
            return subjectOptional.get();
        }else{
            return null;
        }
    }

    public void updateSubject(int id, Subject subject){
        subjectRepo.save(subject);
    }

    public void deleteSubject(long id){
        subjectRepo.deleteById(id);
    }

}
