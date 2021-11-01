package helback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Слой сущностей БД (Model)
 * класс - тип задачи: содержит информацию о типах задач для пользователей
 */
@Entity
@Table(name = "task_type")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_type_id_seq")
    @SequenceGenerator(
            name = "task_type_id_seq",
            sequenceName = "task_type_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "taskType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Task> tasks;

    public TaskType() {
    }

    public TaskType(String type) {
        this.type = type;
    }

    public TaskType(List<Task> tasks, String type) {
        this.tasks = tasks;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "type='" + type + '\'' +
                '}';
    }
}
