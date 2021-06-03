create table public.job_scheduler
(
    id              bigserial,
    job_name        varchar not null,
    job_description varchar,
    executor_class  varchar not null,
    cron_exp        varchar not null
);

insert into public.job_scheduler(job_name, job_description, executor_class, cron_exp)
VALUES ('Hello_Processor', 'Hello World Scheduler', 'com.example.scheduler.processor.HelloProcessor', '* * * * * ?');
