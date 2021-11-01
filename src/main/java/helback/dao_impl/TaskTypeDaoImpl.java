package helback.dao_impl;

import helback.dao_abstract.TaskTypeDao;
import helback.models.TaskType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности TaskType
 */
@Transactional
@Repository
public class TaskTypeDaoImpl extends AbstractDao<Long, TaskType> implements TaskTypeDao {
}
