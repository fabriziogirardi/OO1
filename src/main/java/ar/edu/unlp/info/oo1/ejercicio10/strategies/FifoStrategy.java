package ar.edu.unlp.info.oo1.ejercicio10.strategies;

import ar.edu.unlp.info.oo1.ejercicio10.JobDescription;
import ar.edu.unlp.info.oo1.ejercicio10.interfaces.Strategy;

import java.util.List;

public class FifoStrategy implements Strategy
{
    @Override
    public JobDescription next(List<JobDescription> jobs)
    {
        return jobs.stream().findFirst().orElse(null);
    }
}
