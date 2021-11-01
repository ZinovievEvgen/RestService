package helback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Слой сущностей БД (Model)
 * класс - пользователи: содержит информацию о пользователях
 */
@Entity
@Table(name = "persons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    /*
    @JsonManagedReference и @JsonBackReference
    предназначены для обработки этой двухсторонней связи между полями,
    одна для родительской роли, другая для роли Child.
    @JsonManagedReference - это прямая часть ссылки - та, которая обычно сериализуется.
    @JsonBackReference - это задняя часть reference - он будет опущен из сериализации.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_id_seq")
    @SequenceGenerator(
            name = "persons_id_seq",
            sequenceName = "persons_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "unique_id", unique = true)
    private String uniqueId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "heal_point")
    private Long healPoint;

    @Column(name = "med_point")
    private Long medPoint;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "document")
    private String document;

    @Column(name = "number_document")
    private String numberDocument;

    @Column(name = "country")
    private String country;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonBackReference
    private List<CompleteListTask> completeListTasks;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Task.class)
    @JoinTable(name = "person_access_list",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    @JsonManagedReference
    private List<Task> allowTaskList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "person_friend",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")}
    )
    @JsonManagedReference
    private Set<Person> friends = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "person_friend",
            joinColumns = {@JoinColumn(name = "friend_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")}
    )
    @JsonManagedReference
    private Set<Person> friendOf = new HashSet<>();

    /*@OneToOne(mappedBy = "person")
    private User user;*/

    public Person() {
    }

    public Person(String uniqueId, String country) {
        this.uniqueId = uniqueId;
        this.country = country;
    }

    public Person(String uniqueId, String country, String timezone, LocalTime time, String city) {
        this.uniqueId = uniqueId;
        this.country = country;
        this.timezone = timezone;
        this.time = time;
        this.city = city;
    }

    public Person(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void addAllowTask(Task task) {
        allowTaskList.add(task);
        task.getPersonsAccessList().add(this);
    }

    public void removeAllowTask(Task task) {
        allowTaskList.remove(task);
        task.getPersonsAccessList().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<CompleteListTask> getCompleteListTasks() {
        return completeListTasks;
    }

    public void setCompleteListTasks(List<CompleteListTask> completeListTasks) {
        this.completeListTasks = completeListTasks;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<Task> getAllowTaskList() {
        return allowTaskList;
    }

    public void setAllowTaskList(List<Task> allowTaskList) {
        this.allowTaskList = allowTaskList;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMedPoint() {
        return medPoint;
    }

    public void setMedPoint(Long medPoint) {
        this.medPoint = medPoint;
    }

    public Long getHealPoint() {
        return healPoint;
    }

    public void setHealPoint(Long healPoint) {
        this.healPoint = healPoint;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public Set<Person> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(Set<Person> friendOf) {
        this.friendOf = friendOf;
    }

    @Override
    public String toString() {
        return "Person{" +
                "unique_id='" + uniqueId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                Objects.equals(uniqueId, person.uniqueId) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(name, person.name) &&
                Objects.equals(dateBirth, person.dateBirth) &&
                Objects.equals(document, person.document) &&
                Objects.equals(numberDocument, person.numberDocument) &&
                Objects.equals(country, person.country) &&
                Objects.equals(timezone, person.timezone) &&
                Objects.equals(time, person.time) &&
                Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
