package helback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "translation_task")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "translation_task_id_seq")
    @SequenceGenerator(
            name = "translation_task_id_seq",
            sequenceName = "translation_task_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "description_lang")
    private String descriptionLang;

    @Column(name = "recommendation_lang")
    private String recommendationLang;

    @Column(name = "view_links_lang")
    private String viewLinksLang;

    @Column(name = "language")
    private String language;

    @Column(name = "lang")
    private String lang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendationLang() {
        return recommendationLang;
    }

    public void setRecommendationLang(String recommendationLang) {
        this.recommendationLang = recommendationLang;
    }

    public String getDescriptionLang() {
        return descriptionLang;
    }

    public void setDescriptionLang(String descriptionLang) {
        this.descriptionLang = descriptionLang;
    }

    public String getViewLinksLang() {
        return viewLinksLang;
    }

    public void setViewLinksLang(String viewLinksLang) {
        this.viewLinksLang = viewLinksLang;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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

    @Override
    public String toString() {
        return "TranslationTask{" +
                "descriptionLang='" + descriptionLang + '\'' +
                ", recommendationLang='" + recommendationLang + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslationTask that = (TranslationTask) o;
        return id.equals(that.id) &&
                Objects.equals(descriptionLang, that.descriptionLang) &&
                Objects.equals(recommendationLang, that.recommendationLang) &&
                Objects.equals(viewLinksLang, that.viewLinksLang) &&
                Objects.equals(language, that.language) &&
                Objects.equals(lang, that.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
