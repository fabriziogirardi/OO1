package ar.edu.unlp.info.oo1.ejercicio10;

import ar.edu.unlp.info.oo1.ejercicio10.interfaces.Strategy;
import ar.edu.unlp.info.oo1.ejercicio10.strategies.FifoStrategy;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler
{
    protected List<JobDescription> jobs;
    protected Strategy             strategy;

    public JobScheduler()
    {
        this.jobs     = new ArrayList<>();
        this.strategy = new FifoStrategy();
    }

    public void schedule(JobDescription job)
    {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job)
    {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public Strategy getStrategy()
    {
        return this.strategy;
    }

    public List<JobDescription> getJobs()
    {
        return new ArrayList<>(jobs);
    }

    public void setStrategy(Strategy aStrategy)
    {
        this.strategy = aStrategy;
    }

    public JobDescription next()
    {
        JobDescription nextJob = this.getStrategy().next(this.getJobs());
        this.unschedule(nextJob);
        return nextJob;
    }

}
