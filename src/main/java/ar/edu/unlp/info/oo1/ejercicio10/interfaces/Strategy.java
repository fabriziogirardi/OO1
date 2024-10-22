package ar.edu.unlp.info.oo1.ejercicio10.interfaces;

import ar.edu.unlp.info.oo1.ejercicio10.JobDescription;

import java.util.List;

public interface Strategy
{
    JobDescription next(List<JobDescription> jobDescriptions);
}
