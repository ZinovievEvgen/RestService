package helback.service_impl;

import helback.dao_abstract.PersonDao;
import helback.models.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class PersonServiceImplTest {

    @InjectMocks
    PersonServiceImpl personService;

    @Mock
    PersonDao personDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPersonById() throws Exception {
        when(personDao.getByKey(100L)).thenReturn(new Person("unio1", "Russia", "Europe/MSC", LocalTime.now(), "Moscow"));

        Person person = personService.getPersonById(100L);

        assertEquals("unio1", person.getUniqueId());
        assertEquals("Russia", person.getCountry());
        assertEquals("Europe/MSC", person.getTimezone());
        assertNotNull("Time is not null", person.getTime());
        assertEquals("Moscow", person.getCity());
    }

    @Test
    public void getAllPerson() throws Exception {

        List<Person> list = new ArrayList<Person>();
        Person person1 = new Person("unio1", "Russia", "Europe/MSC", LocalTime.now(), "Moscow");
        Person person2 = new Person("unio2", "Russia", "Europe/MSC", LocalTime.now(), "Moscow");
        Person person3 = new Person("unio3", "Russia", "Europe/MSC", LocalTime.now(), "Moscow");


        list.add(person1);
        list.add(person2);
        list.add(person3);

        when(personDao.getAll()).thenReturn(list);

        //test
        List<Person> personList = personService.getAllPerson();

        assertEquals(3, personList.size());
        verify(personDao, times(1)).getAll();
    }
}