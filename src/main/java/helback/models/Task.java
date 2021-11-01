package helback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - задачи: содержит информацию о задачах для пользователей
 */
@Entity
@Table(name = "tasks")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_id_seq")
    @SequenceGenerator(
            name = "tasks_id_seq",
            sequenceName = "tasks_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "recommendation")
    private String recommendation;

    @Column(name = "med_level")
    private Long medLevel;

    @Column(name = "heal_level", unique = true)
    private Long healLevel;

    @Column(name = "ordered")
    private Long ordered;

    @Column(name = "time_of_day")
    @Enumerated(EnumType.STRING)
    private TimeOfDay timeOfDay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_task_type")
    @JsonManagedReference
    private TaskType taskType;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CompleteListTask> completeListTasks;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<HistoryAnalyseTask> historyAnalyseTasks;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<TranslationTask> translationTasks;

    //если 3 - то живет до 3 часов утра и т.д. Цифра это маркер, а не количество миллисекунд и прочего
    @Column(name = "time_to_live")
    private long timeToLive;

    @Column(name = "quantity_success")
    private long quantitySuccess;

    @Column(name = "count_friend")
    private long countFriend;

    @Column(name = "web_view_link")
    private String viewLinks;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinTable(name = "person_access_list",
            joinColumns = {@JoinColumn(name = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    @JsonBackReference
    private List<Person> personsAccessList;

    public Task() {
    }

    public Task(String description, String recommendation, long timeToLive, long quantitySuccess, String viewLinks) {
        this.description = description;
        this.recommendation = recommendation;
        this.timeToLive = timeToLive;
        this.quantitySuccess = quantitySuccess;
        this.viewLinks = viewLinks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getQuantitySuccess() {
        return quantitySuccess;
    }

    public void setQuantitySuccess(long quantitySuccess) {
        this.quantitySuccess = quantitySuccess;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CompleteListTask> getCompleteListTasks() {
        return completeListTasks;
    }

    public void setCompleteListTasks(List<CompleteListTask> completeListTasks) {
        this.completeListTasks = completeListTasks;
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public List<HistoryAnalyseTask> getHistoryAnalyseTasks() {
        return historyAnalyseTasks;
    }

    public void setHistoryAnalyseTasks(List<HistoryAnalyseTask> historyAnalyseTasks) {
        this.historyAnalyseTasks = historyAnalyseTasks;
    }

    public List<Person> getPersonsAccessList() {
        return personsAccessList;
    }

    public void setPersonsAccessList(List<Person> personsAccessList) {
        this.personsAccessList = personsAccessList;
    }

    public String getViewLinks() {
        return viewLinks;
    }

    public void setViewLinks(String viewLinks) {
        this.viewLinks = viewLinks;
    }

    public Long getMedLevel() {
        return medLevel;
    }

    public void setMedLevel(Long medLevel) {
        this.medLevel = medLevel;
    }

    public Long getHealLevel() {
        return healLevel;
    }

    public void setHealLevel(Long healLevel) {
        this.healLevel = healLevel;
    }

    public List<TranslationTask> getTranslationTasks() {
        return translationTasks;
    }

    public void setTranslationTasks(List<TranslationTask> translationTasks) {
        this.translationTasks = translationTasks;
    }

    public long getCountFriend() {
        return countFriend;
    }

    public void setCountFriend(long countFriend) {
        this.countFriend = countFriend;
    }

    public Long getOrdered() {
        return ordered;
    }

    public void setOrdered(Long ordered) {
        this.ordered = ordered;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
