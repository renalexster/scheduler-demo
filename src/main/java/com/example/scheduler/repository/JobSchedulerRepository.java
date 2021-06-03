package com.example.scheduler.repository;

import com.example.scheduler.model.JobScheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSchedulerRepository extends JpaRepository<JobScheduler, Long> {
}
