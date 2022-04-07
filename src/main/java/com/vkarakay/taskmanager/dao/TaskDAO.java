package com.vkarakay.taskmanager.dao;

import com.vkarakay.taskmanager.entity.Task;

import java.util.List;

public interface TaskDAO {

    public List<Task> getAllTasks ();

    void saveNewTask(Task task);

    public void getTasksByStatus();
}
