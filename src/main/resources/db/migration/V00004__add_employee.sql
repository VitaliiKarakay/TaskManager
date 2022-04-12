create table Employee
(
    id       int auto_increment,
    name     varchar(15) not null,
    surname  varchar(50) not null,
    username varchar(50) not null,
    constraint Employee_pk
        primary key (id)
);

create unique index Employee_username_uindex
    on Employee (username);

alter table tasks
    add develperId int null;

alter table tasks
    add constraint tasks_employee___fk
        foreign key (developerId) references employee (id)
            on delete set null;

alter table tasks
    drop column developer;



