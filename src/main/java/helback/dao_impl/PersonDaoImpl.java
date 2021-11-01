package helback.dao_impl;


import helback.dao_abstract.PersonDao;
import helback.models.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности Person
 */
@Transactional
@Repository
public class PersonDaoImpl extends AbstractDao<Long, Person> implements PersonDao {

    @Override
    public Person getPersonByUniqueId(String uniqueId) {
        return (Person) entityManager.createQuery("select p from Person p where p.uniqueId = :uniqueId").setParameter("uniqueId", uniqueId).getSingleResult();
    }

    @Override
    public Optional<Person> findPersonByUserName(String username) {
        String query = "select p from Person p where p.username = :username";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Person.class)
                .setParameter("username", username)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public Optional<Person> findPersonByUniqueId(String uniqueId) {
        String query = "select p from Person p where p.uniqueId = :uniqueId";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Person.class)
                .setParameter("uniqueId", uniqueId)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public Optional<Person> findPersonByEmail(String email) {
        String query = "select p from Person p where p.email = :email";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Person.class)
                .setParameter("email", email)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }
}
