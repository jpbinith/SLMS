package com.example.slms.Service.Implementation;

import com.example.slms.Entity.Subject;
import com.example.slms.Repository.SubjectRepository;
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

    public void updateSubject(long id, Subject subject){
        Optional<Subject> subjectOptional = subjectRepo.findById(id);
        if(subjectOptional.isPresent()){
//            subjectOptional.get();
            if(!subject.getSubjectName().isEmpty()){
                subjectOptional.get().setSubjectName(subject.getSubjectName());
            }
            if(subject.getCreditValue() != subjectOptional.get().getCreditValue() && subject.getCreditValue() != 0.0){
                subjectOptional.get().setCreditValue(subject.getCreditValue());
            }
            if(subject.getSubjectCategory() != subjectOptional.get().getSubjectCategory() && subject.getSubjectCategory() != null){
                subjectOptional.get().setSubjectCategory(subject.getSubjectCategory());
            }
//            if(subject.getSubjectID() != subjectOptional.get().getSubjectID() && subject.getSubjectID() != 0){
//                subjectOptional.get().setSubjectID(subject.getSubjectID());
//            }
            subjectRepo.save(subjectOptional.get());
        }
    }

    public void deleteSubject(long id){
        subjectRepo.deleteById(id);
    }

}
