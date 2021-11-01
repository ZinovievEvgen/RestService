package helback.service;


import helback.dto.PersonDTO;
import helback.dto.TaskDTO;
import helback.models.Person;
import helback.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Слой бизнес логики (Service)
 * интерфейс service для сущности Person
 */
public interface PersonService {

    boolean getExistPerson(String uniqueId);

    Person getPersonById(Long id);

    PersonDTO getPersonDTOById(Long id);

    Person getPersonByUniqueId(String uniqueId);

    void addPerson(PersonDTO personDTO) throws Exception;

    List<Person> getAllPerson();

    void deletePersonById(Long id);

    void updatePerson(Person person);

    List<TaskDTO> getAllowTaskList(Long id, String lang);

    List<TaskDTO> getAllowTaskListAnother(String uniqueId, String lang);

    List<Long> readerIdTask(String path);

    List<Task> setAllowTaskForPerson(String path);

    List<TaskDTO> completeTaskByPerson(String uniqueId);

    <T> ArrayList<T> joinLists(final List<? extends T> listA, final List<? extends T> listB);

    void addTaskOnAllowTaskList(Long idOfPerson, String path);

    void deleteTaskOnAllowTaskList(Person currentPerson, Task deleteTask);

    void clearCompleteTaskList(Person person, Task deleteTask);

    void updateHealtyPointByPerson(Person person, List<Task> haveAllowTaskList);

    List<PersonDTO> getFriends(String uniqueId);

    Long findFriend(Long idTask, Person person);

    List<TaskDTO> changeCountFriendForTask(Person person);
}
