package io.oggier.backendproject.domain;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_time")
    private String endTime;

    public Course() {}

    public Course(String name, String startTime, String endTime, Teacher teacher) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
    }

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
