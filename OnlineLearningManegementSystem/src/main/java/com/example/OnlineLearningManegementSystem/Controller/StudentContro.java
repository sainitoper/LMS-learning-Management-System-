package com.example.OnlineLearningManegementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineLearningManegementSystem.Entity.Student;
import com.example.OnlineLearningManegementSystem.Service.StudentServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("Student")
public class StudentContro {
    @Autowired
    private StudentServices studentServices;

    @GetMapping
    public List<Student> getAlldetails() {
        return studentServices.getAll();
    }

      @GetMapping("id/{myid}")
    public Student GetByid(@PathVariable long myid) {
        return studentServices.getByid(myid);
    }
     @PostMapping()
    public String Insert(@RequestBody Student student) {
      
         studentServices.createStudent(student);
         return "Done";
    }

    @PutMapping("id/{myid}")
    public String Update(@RequestBody Student student,@PathVariable long myid)
    {
        
        studentServices.update(student, myid);
        return "update";
    }

    @DeleteMapping("id/{myid}")
    public String Delete(@PathVariable long myid)
    {
        studentServices.delete(myid);
        return "delete";
    }
    

}
