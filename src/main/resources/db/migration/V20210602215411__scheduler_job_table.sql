create table public.job_scheduler
(
    id              bigserial,
    job_name        varchar not null,
    job_description varchar,
    executor_class  varchar not null,
    cron_exp        varchar not null
);