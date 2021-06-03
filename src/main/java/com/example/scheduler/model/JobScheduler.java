package com.example.scheduler.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "job_scheduler")
public class JobScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "executor_class")
    private String executorClass;
    @Column(name = "cron_exp")
    private String cronExp;
}
