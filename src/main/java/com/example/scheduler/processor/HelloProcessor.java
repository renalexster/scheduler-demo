package com.example.scheduler.processor;

import lombok.extern.slf4j.Slf4j;
import org.quartz.PersistJobDataAfterExecution;

@Slf4j
@PersistJobDataAfterExecution
public class HelloProcessor extends AbstractJobProcesor {
    @Override
    public void process() {
        log.info("Hello world recover {}", context.isRecovering());
    }
}
