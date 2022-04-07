package com.vkarakay.taskmanager.service;

import com.vkarakay.taskmanager.entity.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();

    public void saveNewTask(Task task);

    public void getTasksByStatus();

}
