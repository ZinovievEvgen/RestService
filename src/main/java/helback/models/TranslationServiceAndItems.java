package helback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "translation_services_and_items")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationServiceAndItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "translation_services_and_items_id_seq")
    @SequenceGenerator(
            name = "translation_services_and_items_id_seq",
            sequenceName = "translation_services_and_items_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "description_lang")
    private String descriptionLang;

    @Column(name = "view_links_lang")
    private String viewLinksLang;

    @Column(name = "location_lang")
    private String locationLang;

    @Column(name = "language")
    private String language;

    @Column(name = "lang")
    private String lang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "items_id")
    @JsonManagedReference
    private ServicesAndItems servicesAndItems;

    public TranslationServiceAndItems() {
    }

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

    public String getViewLinksLang() {
        return viewLinksLang;
    }

    public void setViewLinksLang(String viewLinksLang) {
        this.viewLinksLang = viewLinksLang;
    }

    public String getLocationLang() {
        return locationLang;
    }

    public void setLocationLang(String locationLang) {
        this.locationLang = locationLang;
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

    public ServicesAndItems getServicesAndItems() {
        return servicesAndItems;
    }

    public void setServicesAndItems(ServicesAndItems servicesAndItems) {
        this.servicesAndItems = servicesAndItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslationServiceAndItems that = (TranslationServiceAndItems) o;
        return id.equals(that.id) &&
                Objects.equals(descriptionLang, that.descriptionLang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TranslationServiceAndItems{" +
                "descriptionLang='" + descriptionLang + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
