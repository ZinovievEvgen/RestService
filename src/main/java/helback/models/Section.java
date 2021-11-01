package helback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sections")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sections_id_seq")
    @SequenceGenerator(
            name = "sections_id_seq",
            sequenceName = "sections_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<TranslationSection> translationSections;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ServicesAndItems> servicesAndItems;

    public Section() {

    }

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

    public List<helback.models.ServicesAndItems> getServicesAndItems() {
        return servicesAndItems;
    }

    public void setServicesAndItems(List<helback.models.ServicesAndItems> servicesAndItems) {
        servicesAndItems = servicesAndItems;
    }

    public List<TranslationSection> getTranslationSections() {
        return translationSections;
    }

    public void setTranslationSections(List<TranslationSection> translationSections) {
        this.translationSections = translationSections;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id.equals(section.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Section{" +
                "description='" + description + '\'' +
                '}';
    }
}
