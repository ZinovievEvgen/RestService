package helback.dao_abstract;


import helback.models.Person;

import java.util.Optional;

/**
 * Слой ДАО
 * интерфейс ДАО для Person
 */
public interface PersonDao extends GenericDao<Long, Person> {

    Person getPersonByUniqueId(String uniqueId);

    Optional<Person> findPersonByUserName(String username);

    Optional<Person> findPersonByUniqueId(String uniqueId);

    Optional<Person> findPersonByEmail(String email);
}
