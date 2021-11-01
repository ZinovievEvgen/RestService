package helback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * * Слой объектов представления данных (DTO)
 * класс - SectionDTO: представление сущности Section в упрощенной форме
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectionDTO {

    private Long id;
    private String description;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
