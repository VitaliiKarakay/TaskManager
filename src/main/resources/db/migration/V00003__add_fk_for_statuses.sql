alter table tasks
    add constraint tasks_statuses_id_fk
        foreign key (status) references statuses (id);