package helback.dao_abstract;

import helback.models.Section;

import java.util.List;
import java.util.Optional;

public interface SectionDao extends GenericDao<Long, Section> {

    Optional<Section> getSectionByName(String description);

    List<Section> getSectionsByStatus(String status);

}
