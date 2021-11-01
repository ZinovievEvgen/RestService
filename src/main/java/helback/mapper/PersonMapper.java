package helback.mapper;

import helback.dto.PersonDTO;
import helback.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {
}
