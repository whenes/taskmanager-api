package br.com.taskmanager.taskmanagerapi.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
