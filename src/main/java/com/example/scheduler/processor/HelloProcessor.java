package com.example.scheduler.processor;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

@Slf4j
@PersistJobDataAfterExecution
public class HelloProcessor implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Hello world recover {}", context.isRecovering());
    }
}
