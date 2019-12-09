package io.oggier.backendproject.domain;

public class StudentStatistic extends Student {
    private long average;

    public StudentStatistic(long average) {
        this.average = average;
    }

    public StudentStatistic(String firstname, String lastname, long average) {
        super(firstname, lastname);
        this.average = average;
    }

    public long getAverage() {
        return average;
    }

    public void setAverage(long average) {
        this.average = average;
    }
}
