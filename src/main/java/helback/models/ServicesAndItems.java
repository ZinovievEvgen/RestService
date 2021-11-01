package helback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "services_and_items")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicesAndItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "services_and_items_id_seq")
    @SequenceGenerator(
            name = "services_and_items_id_seq",
            sequenceName = "services_and_items_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "web_view_link")
    private String viewLinks;

    @Column(name = "location")
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    @JsonBackReference
    private Section section;

    @OneToMany(mappedBy = "servicesAndItems", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<TranslationServiceAndItems> translationServiceAndItems;

    public ServicesAndItems() {
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

    public String getViewLinks() {
        return viewLinks;
    }

    public void setViewLinks(String viewLinks) {
        this.viewLinks = viewLinks;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<TranslationServiceAndItems> getTranslationServiceAndItems() {
        return translationServiceAndItems;
    }

    public void setTranslationServiceAndItems(List<TranslationServiceAndItems> translationServiceAndItems) {
        this.translationServiceAndItems = translationServiceAndItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicesAndItems that = (ServicesAndItems) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ServicesAndItems{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
