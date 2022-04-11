package com.vkarakay.taskmanager.dao;

import com.vkarakay.taskmanager.entity.Task;

import java.util.List;

public interface TaskDAO {

    public List<Task> getAllTasks ();

    void saveTask(Task task);

    public List<Task> getTasksByDoneStatus(int id);

    Task getTask(int id);

}
