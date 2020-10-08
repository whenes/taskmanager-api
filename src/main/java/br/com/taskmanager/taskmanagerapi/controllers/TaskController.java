package br.com.taskmanager.taskmanagerapi.controllers;

import br.com.taskmanager.taskmanagerapi.models.dtos.TaskDTO;
import br.com.taskmanager.taskmanagerapi.services.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@RestController
@RequestMapping("/api/task")
@Api(value="API REST Tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @ApiOperation(value="Return list of tasks")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    @ApiOperation(value="Create a new task")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return taskService.save(taskDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete a task by id")
    public String deleteTask(@PathVariable Long id) {
        return taskService.delete(id);
    }

    @PutMapping
    @ApiOperation(value="Update task")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO) {
        return taskService.update(taskDTO);
    }
}
