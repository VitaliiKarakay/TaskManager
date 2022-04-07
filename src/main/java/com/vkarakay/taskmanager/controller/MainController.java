package com.vkarakay.taskmanager.controller;

import com.vkarakay.taskmanager.dao.TaskDAO;
import com.vkarakay.taskmanager.entity.Task;
import com.vkarakay.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getAllTasks(Model model) {

        List<Task> allTasks = taskService.getAllTasks();
        taskService.getTasksByStatus();
        model.addAttribute("allTasks", allTasks);

        return "task_list";
    }

    @RequestMapping("/addNewTask")
    public String addNewTask(Model model) {

        Task task = new Task();
        model.addAttribute("task", task);

        return "task-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveTask(@ModelAttribute ("task") Task task) {

        taskService.saveNewTask(task);

        return "redirect:/";

    }

}
