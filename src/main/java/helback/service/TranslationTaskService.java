package helback.service;


import helback.dto.TaskDTO;
import helback.dto.TranslationTaskDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.TranslationTask;

import java.util.List;

public interface TranslationTaskService {

    TranslationTask getTranslationTaskById(Long id);

    TranslationTaskDTO getTranslationTaskDTOById(Long id);

    List<TranslationTask> getAllTranslationTaskByIdTask(Long idOfTask);

    List<TaskDTO> getTranslationTaskByLangAndTaskForUnPerson(String uniqueId, String lang) throws NotFoundTraslationException;

    List<TaskDTO> getTranslationTaskByLangAndTaskForPerson(Long id, String lang) throws NotFoundTraslationException;

    List<TaskDTO> getTranslationCompleteTaskByLangAndTaskForUnPerson(String uniqueId, String lang) throws NotFoundTraslationException;

    List<TranslationTask> getAll();

    List<TranslationTaskDTO> getAllDTO();

    TaskDTO getTaskByIdWithLang(Long id, String lang) throws NotFoundTraslationException;

    void addTranslationTaskDTO(TranslationTaskDTO translationTaskDTO);

    void deleteTranslationTaskById(Long id);

    void updateTranslationTask(TranslationTaskDTO translationTaskDTO);
}
