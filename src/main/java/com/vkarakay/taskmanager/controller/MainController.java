package com.vkarakay.taskmanager.controller;

import com.vkarakay.taskmanager.dao.TaskDAO;
import com.vkarakay.taskmanager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskDAO taskDAO;

    @GetMapping("/")
    public String getAllTasks(Model model) {

        List<Task> allTasks = taskDAO.getAllTasks();
        model.addAttribute("allTasks", allTasks);

        return "task_list";
    }

}
