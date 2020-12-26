package com.example.slms.Service;

import com.example.slms.Entity.Student;
import com.example.slms.Entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    public void createSubject(Subject subject);
    public List<Subject> getAllSubjects();
    public Subject getSubject(int id);
    public void updateSubject(int id, Subject subject);
    public void deleteSubject(int id);
}
