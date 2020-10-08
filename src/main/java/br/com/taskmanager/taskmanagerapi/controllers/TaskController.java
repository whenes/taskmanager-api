package br.com.taskmanager.taskmanagerapi.controllers;

import br.com.taskmanager.taskmanagerapi.models.dtos.TaskDTO;
import br.com.taskmanager.taskmanagerapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return taskService.save(taskDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.delete(id);
    }

    @PutMapping
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO) {
        return taskService.update(taskDTO);
    }
}
