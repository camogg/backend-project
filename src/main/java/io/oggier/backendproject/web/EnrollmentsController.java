package io.oggier.backendproject.web;

import io.oggier.backendproject.domain.Enrollment;
import io.oggier.backendproject.repository.CourseRepository;
import io.oggier.backendproject.repository.EnrollmentRepository;
import io.oggier.backendproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EnrollmentsController {
    @Autowired
    private EnrollmentRepository repository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    // RESTful service to get all enrollments
    @RequestMapping(value="/enrollments", method = RequestMethod.GET)
    public @ResponseBody
    List<Enrollment> getEnrollments() {
        return repository.findAll();
    }

    // RESTful service to get enrollment by id
    @RequestMapping(value = "/enrollments/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Enrollment> findEnrollmentById(@PathVariable("id") Long enrollmentId) {
        return repository.findById(enrollmentId);
    }

    // RESTful service to add new enrollment
    @RequestMapping(value = "/enrollments", method = RequestMethod.POST)
    public @ResponseBody Enrollment addEnrollment(Enrollment enrollment){
        repository.save(enrollment);
        return enrollment;
    }

    // RESTful service to modify enrollment
    @RequestMapping(value = "/enrollments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEnrollment(@RequestBody Enrollment enrollment, @PathVariable long id) {
        Optional<Enrollment> enrollmentOptional = repository.findById(id);
        if (!enrollmentOptional.isPresent())
            return ResponseEntity.notFound().build();
        enrollment.setId(id);
        studentRepository.save(enrollment.getStudent());
        courseRepository.save(enrollment.getCourse());
        repository.save(enrollment);
        return ResponseEntity.noContent().build();
    }

    // RESTful service to delete enrollment
    @RequestMapping(value = "/enrollments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEnrollment(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
