package io.oggier.backendproject;

import io.oggier.backendproject.domain.Enrollment;
import io.oggier.backendproject.domain.Student;
import io.oggier.backendproject.repository.CourseRepository;
import io.oggier.backendproject.repository.EnrollmentRepository;
import io.oggier.backendproject.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class JPATests {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Testing that out custom search returns the expected amount of results
    @Test
    public void findByStudent() {
        Student student = studentRepository.findById(0l).get();
        List<Enrollment> enrollments = enrollmentRepository.findByStudent(student);

        assert enrollments.size() > 0;
    }
}
