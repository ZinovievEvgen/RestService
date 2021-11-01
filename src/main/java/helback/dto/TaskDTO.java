package helback.dto;

import helback.models.TimeOfDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {

    private Long id;
    private String description;
    private String recommendation;
    private Long medLevel;
    private Long healLevel;
    private long timeToLive;
    private long quantitySuccess;
    private long countFriend;
    private String viewLinks;
    private Long ordered;
    private TimeOfDay timeOfDay;
    private Long taskTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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

    public long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public long getQuantitySuccess() {
        return quantitySuccess;
    }

    public void setQuantitySuccess(long quantitySuccess) {
        this.quantitySuccess = quantitySuccess;
    }

    public long getCountFriend() {
        return countFriend;
    }

    public void setCountFriend(long countFriend) {
        this.countFriend = countFriend;
    }

    public String getViewLinks() {
        return viewLinks;
    }

    public void setViewLinks(String viewLinks) {
        this.viewLinks = viewLinks;
    }

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
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
}
