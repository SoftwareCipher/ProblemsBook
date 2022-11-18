package com.problem.book.controller;

import com.problem.book.models.Tasks;
import com.problem.book.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Tasks> data = taskRepository.findAll();
        model.addAttribute("tasks", data);
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @PostMapping("/")
    public String saveTask(@RequestParam String task, Model model) {
        if (task.length() < 5) {
            Iterable<Tasks> t = taskRepository.findAll();
            model.addAttribute("tasks", t);
            model.addAttribute("title", "Главная страница");
            model.addAttribute("error", "Текст задания не менее 5 символов");
            return "home";
        }
        Tasks taskObj = new Tasks(task);
        taskRepository.save(taskObj);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String deleteTask(@PathVariable(value = "id") long id, Model model) {
        Tasks tasks = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(tasks);
        return "redirect:/";
    }
}
