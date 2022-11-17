package com.problem.book.controller;

import com.problem.book.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;


}
