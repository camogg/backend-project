package io.oggier.backendproject.web;

import io.oggier.backendproject.domain.Course;
import io.oggier.backendproject.domain.CourseStatistic;
import io.oggier.backendproject.domain.Enrollment;
import io.oggier.backendproject.repository.CourseRepository;
import io.oggier.backendproject.repository.EnrollmentRepository;
import io.oggier.backendproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CoursesController {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // RESTful service to get all courses
    @RequestMapping(value="/courses", method = RequestMethod.GET)
    public @ResponseBody
    List<Course> getCourses() {
        return (List<Course>) repository.findAll();
    }

    // RESTful service to get course by id
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Course> findCourseById(@PathVariable("id") Long courseId) {
        return repository.findById(courseId);
    }

    // RESTful service to get course's statistics by id
    @RequestMapping(value = "/courses/{id}/stats", method = RequestMethod.GET)
    public @ResponseBody
    CourseStatistic getStatistics(@PathVariable("id") Long courseId) {
        Course course =  repository.findById(courseId).get();
        List<Enrollment> students = enrollmentRepository.findByCourse(course);
        long grades = 0;
        for (Enrollment enrollment: students
             ) {
            grades += enrollment.getGrade();
        }
        CourseStatistic courseStats = new CourseStatistic(course.getName(), course.getStartTime(), course.getEndTime(), course.getTeacher(), grades/students.size());
        return courseStats;
    }

    // RESTful service to add new course
    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public @ResponseBody Course addCourse(Course course){
        repository.save(course);
        return course;
    }

    // RESTful service to modify course
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable long id) {
        Optional<Course> courseOptional = repository.findById(id);
        if (!courseOptional.isPresent())
            return ResponseEntity.notFound().build();
        course.setId(id);
        teacherRepository.save(course.getTeacher());
        repository.save(course);
        return ResponseEntity.noContent().build();
    }

    // RESTful service to delete course
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCourse(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
