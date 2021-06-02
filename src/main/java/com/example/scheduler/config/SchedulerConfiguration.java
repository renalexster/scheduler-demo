package com.example.scheduler.config;

import com.example.scheduler.processor.HelloProcessor;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class SchedulerConfiguration {

    @Bean
    public Scheduler scheduler(SchedulerFactoryBean factoryBean) throws SchedulerException {
        Scheduler scheduler = factoryBean.getScheduler();

        if (!scheduler.checkExists(new JobKey("helloJob"))) {
            scheduler.scheduleJob(
                    JobBuilder.newJob(HelloProcessor.class).withIdentity("helloJob").build(),
                    TriggerBuilder.newTrigger()
                            .withIdentity("someTrigger")
                            .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                            .build()
            );
        }

        return scheduler;
    }

}
