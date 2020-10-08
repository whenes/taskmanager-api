package br.com.taskmanager.taskmanagerapi.services;

import br.com.taskmanager.taskmanagerapi.models.Task;
import br.com.taskmanager.taskmanagerapi.models.dtos.TaskDTO;
import br.com.taskmanager.taskmanagerapi.models.enums.TaskStatus;
import br.com.taskmanager.taskmanagerapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllTasks() {
        return transformListModelToListDTO(taskRepository.findAll());
    }

    public TaskDTO save(TaskDTO taskDTO) {
        Task task = transformDTOToModel(taskDTO);
        return transformModelToDTO(taskRepository.save(task));
    }

    public String delete(Long id) {
        try {
            taskRepository.deleteById(id);
            return "Task successfully removed!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public TaskDTO update(TaskDTO taskDTO) {
        return save(taskDTO);
    }

    public Task transformDTOToModel(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus().equals("TODO") ? TaskStatus.TODO : TaskStatus.DONE);
        return task;
    }

    public TaskDTO transformModelToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus().toString());
        return taskDTO;
    }

    public List<TaskDTO> transformListModelToListDTO(List<Task> tasks) {
        List<TaskDTO> taskDTOS =  new ArrayList<>();
        for (Task task: tasks) {
            TaskDTO taskDTO = transformModelToDTO(task);
            taskDTOS.add(taskDTO);
        }
        return taskDTOS;
    }
}
