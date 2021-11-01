package helback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslationServiceAndItemsDTO {

    private Long id;
    private String descriptionLang;
    private String viewLinksLang;
    private String locationLang;
    private String language;
    private String lang;
    private Long serviceId;

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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
