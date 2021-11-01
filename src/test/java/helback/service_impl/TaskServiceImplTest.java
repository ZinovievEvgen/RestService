package helback.service_impl;

import helback.dao_abstract.TaskDao;
import helback.models.Task;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TaskServiceImplTest {

    @InjectMocks
    TaskServiceImpl taskService;

    @Mock
    TaskDao taskDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTaskById() throws Exception {
        when(taskDao.getByKey(100L)).thenReturn(new Task("description1", "recom1", 3, 5, "url1"));

        Task task = taskService.getTaskById(100L);

        assertEquals("description1", task.getDescription());
        assertEquals("recom1", task.getRecommendation());
        assertEquals(3, task.getTimeToLive());
        assertEquals(5, task.getQuantitySuccess());
        assertEquals("url1", task.getViewLinks());
    }

    @Test
    public void getAll() throws Exception {
        List<Task> list = new ArrayList<Task>();
        Task task1 = new Task("description1", "recom1", 3, 5, "url1");
        Task task2 = new Task("description2", "recom2", 3, 5, "url2");
        Task task3 = new Task("description3", "recom3", 3, 5, "url3");


        list.add(task1);
        list.add(task2);
        list.add(task3);

        when(taskDao.getAll()).thenReturn(list);

        //test
        List<Task> personList = taskService.getAll();

        assertEquals(3, personList.size());
        verify(taskDao, times(1)).getAll();
    }
}