package com.example.scheduler.config;

import com.example.scheduler.model.JobScheduler;
import com.example.scheduler.processor.AbstractJobProcesor;
import com.example.scheduler.repository.JobSchedulerRepository;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
@Slf4j
public class SchedulerConfiguration {

    @Bean
    public Scheduler scheduler(SchedulerFactoryBean factoryBean, JobSchedulerRepository repository) throws SchedulerException {
        Scheduler scheduler = factoryBean.getScheduler();

        repository.findAll().forEach(d -> registerJobScheduler(d, scheduler));

        return scheduler;
    }

    private void registerJobScheduler(JobScheduler jobScheduler, Scheduler scheduler) {

        try {
            if (!scheduler.checkExists(new JobKey(jobScheduler.getJobName()))) {

                Class<? extends AbstractJobProcesor> clazz = (Class<? extends AbstractJobProcesor>) Class.forName(jobScheduler.getExecutorClass());

                scheduler.scheduleJob(
                        JobBuilder.newJob(clazz)
                                .withIdentity(jobScheduler.getJobName()).build(),
                        TriggerBuilder.newTrigger()
                                .withIdentity("TRIGGER_".concat(jobScheduler.getJobName()))
                                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                                .build()
                );
            }
        } catch (Exception e) {
            log.warn("Error registrering JobScheduler {}", jobScheduler.getJobName());
        }

    }

}
