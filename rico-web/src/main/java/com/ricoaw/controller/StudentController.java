package com.ricoaw.controller;

import com.ricoaw.StudentAssembler;
import com.ricoaw.entity.Student;
import com.ricoaw.entity.StudentDto;
import com.ricoaw.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rico on 2/1/2018.
 */
@RestController
public class StudentController {

    @Inject
    StudentAssembler assembler;

    @Autowired
    StudentRepository repository;

    @RequestMapping(value = "/student/list",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = repository.findAll();

        List<StudentDto> studentDtos = assembler.fromEntity(students);

        return new ResponseEntity(studentDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/student/add",method = RequestMethod.POST)
    public ResponseEntity put(
            @RequestParam(value="name") String name, @RequestParam(value="nim") String nim, @RequestParam(value="grade") String grade
            ){
        Student student = new Student();
        student.setName(name);
        student.setGrade(grade);
        student.setNim(nim);

        repository.save(student);

        StudentDto studentDto = assembler.fromEntity(student);

        return ResponseEntity.ok(studentDto);
    }

    @RequestMapping(value = "/student/delete",method = RequestMethod.POST)
    public ResponseEntity delete(
            String name
    ){
        Student student = repository.findByName(name);

        repository.delete(student.getId());

        List<Student> students = repository.findAll();

        return ResponseEntity.ok(students);
    }

    @RequestMapping(value = "/student/update",method = RequestMethod.GET)
    public ResponseEntity update(
        Student student
    ){
        repository.save(student);

        return ResponseEntity.ok(student);
    }
}
