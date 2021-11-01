package helback.dao_abstract;

import java.io.Serializable;
import java.util.List;

/**
 * Слой ДАО
 * общий интерфейс для интерфейсов ДАО
 */
public interface GenericDao<PK extends Serializable, T> {

    void persist(T entity);

    T getByKey(PK id);

    List<T> getAll();

    void update(T group);

    void deleteByKey(PK id);
}
