package com.example.scheduler.processor;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public abstract class AbstractJobProcesor implements Job {
    protected JobExecutionContext context;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("Start processor {}", getClass().getSimpleName());
        this.context = context;
        process();
    }

    protected abstract void process();
}
