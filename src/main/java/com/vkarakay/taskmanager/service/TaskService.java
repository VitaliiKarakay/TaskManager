package com.vkarakay.taskmanager.service;

import com.vkarakay.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();

    public Task getTask(int id);

    public void saveTask(Task task);

    public List<Task> getTasksByDoneStatus(int id);


}
