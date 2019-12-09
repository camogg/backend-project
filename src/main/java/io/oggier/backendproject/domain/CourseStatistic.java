package io.oggier.backendproject.domain;

public class CourseStatistic extends Course {
    private long average;

    public CourseStatistic(String name, String startTime, String endTime, Teacher teacher, long average) {
        super(name, startTime, endTime, teacher);
        this.average = average;
    }

    public long getAverage() {
        return average;
    }

    public void setAverage(long average) {
        this.average = average;
    }
}
