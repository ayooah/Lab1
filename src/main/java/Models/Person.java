package Models;

import java.time.LocalDate;
/**
 * Class describing a person
 * @autor Anna Ushakova
 */
public class Person {
    /**
     * ID of the person
     */
    private int id;
    /**
     * Name of the person
     */
    private String fio;
    /**
     * Birthday of the person
     */
    private LocalDate birthday;
    /**
     * Gender of the person
     */
    private String gender;
    /**
     * Serial number of passport of the person
     */
    private String serialNumberOfPassport;
    /**
     * Age of the person
     */
    private int age;
    /**
     * Constructor - creating new person.
     * @param id
     * @param fio
     * @param birthday
     * @param gender
     * @param serialNumberOfPassport
     */
    public Person(int id, String fio, LocalDate birthday, String gender, String serialNumberOfPassport) {
        this.id = id;
        this.fio = fio;
        this.birthday = birthday;
        this.gender = gender;
        this.serialNumberOfPassport = serialNumberOfPassport;
        this.age=LocalDate.now().getYear()-birthday.getYear();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSerialNumberOfPassport() {
        return serialNumberOfPassport;
    }

    public void setSerialNumberOfPassport(String serialNumberOfPassport) {
        this.serialNumberOfPassport = serialNumberOfPassport;
    }

    public int getAge() {
        return age;
    }
}
