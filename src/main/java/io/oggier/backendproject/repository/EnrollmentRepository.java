package io.oggier.backendproject.repository;

import java.util.List;

import io.oggier.backendproject.domain.Course;
import io.oggier.backendproject.domain.Enrollment;
import io.oggier.backendproject.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourse(Course course);
    List<Enrollment> findByStudent(Student student);
}