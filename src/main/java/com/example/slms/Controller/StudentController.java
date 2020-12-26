package com.example.slms.Controller;

import com.example.slms.Entity.Student;
import com.example.slms.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RequestMapping( path = "/slms" )
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    // new --> controller to service
    @RequestMapping( value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
    @RequestMapping( value = "/students/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }
    @RequestMapping( value = "/students", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }
    @RequestMapping( value = "/students/{id}", method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateStudent(id, student);
    }
    @RequestMapping( value = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }


//    @Autowired
//    private StudentRepository studentRepository;

    // controller to repository

//    @PostMapping( path = "/add" )
//    public @ResponseBody String addNewStudent(@RequestParam String id, @RequestParam String fname, @RequestParam String lname, @RequestParam GenderEnum gender, @RequestParam String grade){
//        Student student = new Student();
//        student.setStudentId(id);
//        student.setFirstName(fname);
//        student.setLastName(lname);
//        student.setGender(gender);
//        student.setGrade(grade);
//        studentRepository.save(student);
//        return "Student Saved";
//    }

//    @RequestMapping( path = "/all")
//    public @ResponseBody Iterable<Student> getAllStudents(){
//        return  studentRepository.findAll();
//    }


}
