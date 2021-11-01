package helback.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "translation_section")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationSection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "translation_section_id_seq")
    @SequenceGenerator(
            name = "translation_section_id_seq",
            sequenceName = "translation_section_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "description_lang")
    private String descriptionLang;

    @Column(name = "language")
    private String language;

    @Column(name = "lang")
    private String lang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    @JsonManagedReference
    private Section section;

    public TranslationSection() {
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslationSection that = (TranslationSection) o;
        return id.equals(that.id) &&
                Objects.equals(descriptionLang, that.descriptionLang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TranslationSection{" +
                "descriptionLang='" + descriptionLang + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
