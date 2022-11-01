package org.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Scheduler {

    List<Job> jobs = new ArrayList<>();
    private static Scheduler instance;
    private Scheduler(){}

    static{
        instance = new Scheduler();
    }

    public static Scheduler getInstance(){return instance;}


    public Job forAction(IRunNotSafeAction randomlyThrowsAnError) {
        return new Job(randomlyThrowsAnError);
    }
    public List<Job> getJobs() {
        //tworzenie kopii kolekcji może poprawić wyjątek (doszedłem do tego po zakończonym nagraniu)
        return new ArrayList<>(jobs);
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }
}