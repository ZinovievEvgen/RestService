package helback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * * Слой объектов представления данных (DTO)
 * класс - ServicesAndItemsDTO: представление сущности ServicesAndItems в упрощенной форме
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceAndItemsDTO {

    private Long id;
    private String description;
    private String viewLinks;
    private String location;
    private Long sectionId;

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

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
