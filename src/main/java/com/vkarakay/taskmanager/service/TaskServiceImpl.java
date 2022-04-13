package com.vkarakay.taskmanager.service;

import com.vkarakay.taskmanager.dao.EmployeeDAO;
import com.vkarakay.taskmanager.dao.TaskDAO;
import com.vkarakay.taskmanager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDAO taskDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Task> getAllTasks() {
        List<Task> allTasks = taskDAO.getAllTasks();
        return allTasks;
    }

    @Override
    @Transactional
    public Task getTask(int id) {
        Task task = taskDAO.getTask(id);

        return task;
    }

    @Override
    @Transactional
    public void saveTask(Task task) {
        taskDAO.saveTask(task);
    }

    @Override
    @Transactional
    public List<Task> getTasksByDoneStatus(int id) {
       return taskDAO.getTasksByDoneStatus(id);
    }


}
