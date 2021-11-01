package helback.dao_abstract;


import helback.exception.NotFoundTraslationException;
import helback.models.TranslationTask;

import java.util.List;
import java.util.Optional;

public interface TranslationTaskDao extends GenericDao<Long, TranslationTask> {

    Optional<TranslationTask> getTranslationTaskByIdOfTaskAndIdOfLang(Long idOfTask, String idOfLang) throws NotFoundTraslationException;

    List<TranslationTask> getAllTranslationTaskByIdTask(Long idOfTask);
}
