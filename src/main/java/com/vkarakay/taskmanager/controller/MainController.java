package com.vkarakay.taskmanager.controller;

import com.vkarakay.taskmanager.entity.Employee;
import com.vkarakay.taskmanager.entity.Task;
import com.vkarakay.taskmanager.service.EmployeeService;
import com.vkarakay.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getAllTasks(Model model) {

        List<Task> allTasks = taskService.getAllTasks();
        model.addAttribute("allTasks", allTasks);

        return "task_list";
    }

    @GetMapping("/getTasksByDoneStatus")
    public String getTasksByDoneStatus(@RequestParam ("doneId")int doneId, Model model) {

        List<Task> allTasks = taskService.getTasksByDoneStatus(doneId);
        System.out.println(allTasks);
        model.addAttribute("allTasks", allTasks);

        return "task_list";
    }

    @RequestMapping("/addNewTask")
    public String addNewTask(Model model) {

        Task task = new Task();
        model.addAttribute("task", task);

        return "new-task";
    }

    public void someM(Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        if (task.getStatus().getId() == 4) {
            task.setDone(1);
        }
        taskService.saveTask(task);

        return "redirect:/";
    }

    @RequestMapping("/makeDone")
    public String makeTaskDone(@RequestParam("taskID") int id, Model model) {

        Task task = taskService.getTask(id);
        task.setDone(1);
        task.getStatus().setId(4);
        model.addAttribute(task);
        taskService.saveTask(task);

        return "redirect:/";
    }

    @RequestMapping("/updateTask")
    public String updateTask(@RequestParam("taskID") int id, Model model) {

        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "update-task";
    }

}
