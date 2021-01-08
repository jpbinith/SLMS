package com.example.slms.Controller;

import com.example.slms.Entity.Subject;
import com.example.slms.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping( path = "/slms" )
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping( value = "/subjects", method = RequestMethod.POST)
    public void createSubject(@RequestBody Subject subject) {
        subjectService.createSubject(subject);
    }

    @RequestMapping( value = "/subjects", method = RequestMethod.GET)
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @RequestMapping( value = "/subjects/{id}", method = RequestMethod.GET)
    public Subject getSubject(@PathVariable long id) {
        return subjectService.getSubject(id);
    }

    @RequestMapping( value = "/subjects/{id}", method = RequestMethod.PUT)
    public void updateSubject(@PathVariable long id, @RequestBody Subject subject) {
        subjectService.updateSubject(id, subject);
    }

    @RequestMapping( value = "/subjects/{id}", method = RequestMethod.DELETE)
    public void deleteSubject(@PathVariable long id) {
        subjectService.deleteSubject(id);
    }

}
