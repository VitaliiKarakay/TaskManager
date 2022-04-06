create table tasks
(
    id        int auto_increment,
    shortname varchar(50)           not null,
    developer varchar(50)           not null,
    done      boolean default false not null,
    constraint tasks_pk
        primary key (id)
);

create table statuses
(
    id   int auto_increment,
    name varchar(15) not null,
    constraint statuses_pk
        primary key (id)
);

create unique index statuses_name_uindex
    on statuses (name);

alter table tasks
    add status int null after developer;

alter table tasks
    add constraint status_fk
        foreign key (status) references statuses (id);

