package helback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslationTaskDTO {

    private Long id;
    private String descriptionLang;
    private String recommendationLang;
    private String viewLinksLang;
    private String language;
    private String lang;
    private Long taskId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionLang() {
        return descriptionLang;
    }

    public void setDescriptionLang(String descriptionLang) {
        this.descriptionLang = descriptionLang;
    }

    public String getRecommendationLang() {
        return recommendationLang;
    }

    public void setRecommendationLang(String recommendationLang) {
        this.recommendationLang = recommendationLang;
    }

    public String getViewLinksLang() {
        return viewLinksLang;
    }

    public void setViewLinksLang(String viewLinksLang) {
        this.viewLinksLang = viewLinksLang;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
