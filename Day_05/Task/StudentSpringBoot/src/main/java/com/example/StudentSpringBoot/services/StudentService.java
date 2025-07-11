package com.example.StudentSpringBoot.services;

import com.example.StudentSpringBoot.Repository.StudentRepo;
import com.example.StudentSpringBoot.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studrep;

    public List<Students> showstudents(){
        return studrep.findAll();
    }

    public Students getStudentById(int id) {
        return studrep.findReferenceById(id);
    }

    public List<Students> getStudentByname(@PathVariable String name) {
        return studrep.findStudentsByName(name);
    }

    public String addStudent(@RequestBody Students student) {
         studrep.save(student);
         return "Student added successfully";
    }


    public String updatedStudent(int id,Students student) {
         List<Students> students = studrep.findAll();
         for(Students s: students){
             if(s.getId()==id){
                 studrep.deleteById(id);
                 studrep.save(student);
             }
         }
         return "Student updated successfully";
    }

    public String deletestudent(int id) {
        studrep.deleteById(id);
        return "Student deleted successfully";
    }

}
