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

    // RESTful service to get all teachers
    @RequestMapping(value="/teachers", method = RequestMethod.GET)
    public @ResponseBody
    List<Teacher> getTeachers() {
        return repository.findAll();
    }

    // RESTful service to get teacher by id
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Teacher> findTeacherById(@PathVariable("id") Long teacherId) {
        return repository.findById(teacherId);
    }

    // RESTful service to add new teacher
    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public @ResponseBody Teacher addTeacher(Teacher teacher){
        repository.save(teacher);
        return teacher;
    }

    // RESTful service to modify teacher
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTeacher(@RequestBody Teacher teacher, @PathVariable long id) {
        Optional<Teacher> teacherOptional = repository.findById(id);
        if (!teacherOptional.isPresent())
            return ResponseEntity.notFound().build();
        teacher.setId(id);
        repository.save(teacher);
        return ResponseEntity.noContent().build();
    }

    // RESTful service to delete teacher
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTeacher(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
