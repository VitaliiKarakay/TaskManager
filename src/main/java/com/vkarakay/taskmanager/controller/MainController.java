package com.vkarakay.taskmanager.controller;

import com.vkarakay.taskmanager.entity.Task;
import com.vkarakay.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "new-task";
    }

    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute ("task") Task task) {

        taskService.saveTask(task);

        return "redirect:/";
    }

    @RequestMapping("/makeDone")
    public String makeTaskDone(@RequestParam ("taskID") int id, Model model) {

        Task task = taskService.getTask(id);
        task.setDone(1);
        task.setStatus(4);
        model.addAttribute(task);
        taskService.saveTask(task);

        return "redirect:/";
    }

    @RequestMapping("/updateTask")
    public String updateTask(@RequestParam("taskID") int id, Model model) {
        return "";
    }

}
