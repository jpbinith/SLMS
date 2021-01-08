package com.example.slms.Service;

import com.example.slms.Entity.Subject;
import java.util.List;

public interface SubjectService {

    void createSubject(Subject subject);
    List<Subject> getAllSubjects();
    Subject getSubject(long id);
    void updateSubject(long id, Subject subject);
    void deleteSubject(long id);
}
