package io.oggier.backendproject.web;

import io.oggier.backendproject.domain.Teacher;
import io.oggier.backendproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TeachersController {

    @Autowired
    private TeacherRepository repository;

    // RESTful service to get all students
    @RequestMapping(value="/teachers", method = RequestMethod.GET)
    public @ResponseBody
    List<Teacher> getStudents() {
        return repository.findAll();
    }

    // RESTful service to get student by id
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Teacher> findStudentById(@PathVariable("id") Long studentId) {
        return repository.findById(studentId);
    }

    // RESTful service to add new student
    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public @ResponseBody Teacher addStudent(Teacher teacher){
        repository.save(teacher);
        return teacher;
    }

    // RESTful service to modify student
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@RequestBody Teacher teacher, @PathVariable long id) {
        Optional<Teacher> studentOptional = repository.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        teacher.setId(id);
        repository.save(teacher);
        return ResponseEntity.noContent().build();
    }

    // RESTful service to delete student
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudent(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
