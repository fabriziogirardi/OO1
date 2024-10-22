package ar.edu.unlp.info.oo1.ejercicio10.strategies;

import ar.edu.unlp.info.oo1.ejercicio10.JobDescription;
import ar.edu.unlp.info.oo1.ejercicio10.interfaces.Strategy;

import java.util.Comparator;
import java.util.List;

public class HighestPriorityStrategy implements Strategy
{
    @Override
    public JobDescription next(List<JobDescription> jobDescriptions)
    {
        return jobDescriptions.stream().max(Comparator.comparingDouble(JobDescription::getPriority)).orElse(null);
    }
}
