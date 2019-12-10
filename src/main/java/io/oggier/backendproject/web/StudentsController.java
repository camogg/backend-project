package io.oggier.backendproject.web;

import io.oggier.backendproject.domain.Enrollment;
import io.oggier.backendproject.domain.Student;
import io.oggier.backendproject.domain.StudentStatistic;
import io.oggier.backendproject.repository.EnrollmentRepository;
import io.oggier.backendproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentsController {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // RESTful service to get all students
    @RequestMapping(value="/students", method = RequestMethod.GET)
    public @ResponseBody
    List<Student> getStudents() {
        return (List<Student>) repository.findAll();
    }

    // RESTful service to get student by id
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Student> findStudentById(@PathVariable("id") Long studentId) {
        return repository.findById(studentId);
    }

    // RESTful service to get student's statistics by id
    @RequestMapping(value = "/students/{id}/stats", method = RequestMethod.GET)
    public @ResponseBody
    StudentStatistic getStatistics(@PathVariable("id") Long studentId) {
        Student student =  repository.findById(studentId).get();
        List<Enrollment> students = enrollmentRepository.findByStudent(student);
        long grades = 0;
        for (Enrollment enrollment: students
        ) {
            grades += enrollment.getGrade();
        }
        StudentStatistic studentStatistic = new StudentStatistic(student.getFirstname(), student.getLastname(), grades/students.size());
        return studentStatistic;
    }

    // RESTful service to add new student
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public @ResponseBody Student addStudent(Student student){
        repository.save(student);
        return (Student) student;
    }

    // RESTful service to modify student
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
        Optional<Student> studentOptional = repository.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        student.setId(id);
        repository.save(student);
        return ResponseEntity.noContent().build();
    }

    // RESTful service to delete student
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudent(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
