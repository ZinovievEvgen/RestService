package helback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Слой сущностей БД (Model)
 * класс - задачи: содержит информацию о результатах выполнения задач за истекший период
 */
@Entity
@Table(name = "history_analyses_task")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryAnalyseTask {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_analyses_task_id_seq")
    @SequenceGenerator(
            name = "history_analyses_task_id_seq",
            sequenceName = "history_analyses_task_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private Task task;

    @Column(name = "count_to_complete")
    private Long countToComplete;

    public HistoryAnalyseTask() {
    }

    public HistoryAnalyseTask(LocalDate date, Task task, Long countToComplete) {
        this.date = date;
        this.task = task;
        this.countToComplete = countToComplete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountToComplete() {
        return countToComplete;
    }

    public void setCountToComplete(Long countToComplete) {
        this.countToComplete = countToComplete;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryAnalyseTask{" +
                "date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryAnalyseTask that = (HistoryAnalyseTask) o;
        return id.equals(that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(task, that.task) &&
                Objects.equals(countToComplete, that.countToComplete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
