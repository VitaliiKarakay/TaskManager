alter table tasks
    add constraint tasks_statuses_id_fk
        foreign key (status) references statuses (id);

CREATE TRIGGER stop_update BEFORE UPDATE ON task_manager.statuses
    FOR EACH ROW
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Update not allowed!'