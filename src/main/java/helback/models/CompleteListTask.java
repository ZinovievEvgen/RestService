package helback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Слой сущностей БД (Model)
 * класс - CompleteListTaskService: учет выполненых заданий пользователями
 */
@Entity
@Table(name = "complete_list_task")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompleteListTask {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complete_list_task_id_seq")
    @SequenceGenerator(
            name = "complete_list_task_id_seq",
            sequenceName = "complete_list_task_id_seq",
            allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonManagedReference
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private Task task;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "complete_date")
    private LocalDateTime completeDate;


    public CompleteListTask() {
    }

    public CompleteListTask(Person person, LocalDateTime createDate, Task task) {
        this.person = person;
        this.createDate = createDate;
        this.task = task;
    }

    public CompleteListTask(Person person, Task task, LocalDateTime completeDate) {
        this.person = person;
        this.completeDate = completeDate;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(LocalDateTime completeDate) {
        this.completeDate = completeDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "CompleteListTaskService{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteListTask that = (CompleteListTask) o;
        return id.equals(that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(task, that.task) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(completeDate, that.completeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, task, createDate, completeDate);
    }
}
