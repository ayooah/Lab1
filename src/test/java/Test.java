import Models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Test {
    private Repository<Contract> repository = new ArrayRepository<>();

    @BeforeEach
    void setUp() {
        repository.add(new InternetContract(10, LocalDate.of(2021, 4, 2), LocalDate.of(2021, 5, 2), 10,
                new Person(2, "UAA", LocalDate.of(1993, 2, 12), "female", "2017234108"), 300));
        repository.add(new InternetContract(6, LocalDate.of(2018, 2, 4), LocalDate.of(2018, 5, 4), 8,
                new Person(1, "MTA", LocalDate.of(1997, 4, 15), "male", "2019564038"), 200));
        repository.add(new TelevisionContract(5, LocalDate.of(2020, 8, 25), LocalDate.of(2020, 9, 25), 5,
                new Person(7, "AHN", LocalDate.of(1983, 12, 7), "female", "2007754108"), new ArrayList<>()));

    }

    @org.junit.jupiter.api.Test
    void testGetSize() {

        assertEquals(3, repository.getSize());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        repository.add(new TelevisionContract(11, LocalDate.of(2017, 8, 25), LocalDate.of(2020, 9, 25), 5,
                new Person(1, "MTA", LocalDate.of(1997, 4, 15), "male", "2019564038"), new ArrayList<>()));
        int size = repository.getSize();
        assertEquals(4, size);
    }

    @org.junit.jupiter.api.Test
    void testGetById() {

        assertEquals(10, repository.getbyId(10).getNumber());
    }

    @org.junit.jupiter.api.Test
    void testGetByIndex() {

        assertEquals(8, repository.getbyIndex(1).get().getNumber());
    }

    @org.junit.jupiter.api.Test
    void testAddArr() {
        MobileContract[] arr = new MobileContract[2];
        arr[0] = new MobileContract(4, LocalDate.of(2019, 5, 24), LocalDate.of(2019, 6, 24), 6,
                new Person(1, "MTA", LocalDate.of(1997, 4, 15), "male", "2019564038"), 200, 100, 20);
        arr[1] = new MobileContract(3, LocalDate.of(2021, 4, 2), LocalDate.of(2021, 5, 2), 3,
                new Person(2, "UAA", LocalDate.of(1993, 2, 12), "female", "2017234108"), 300, 200, 20);
        repository.addArr(arr);
        int size = repository.getSize();
        assertEquals(5, size);
    }

    @org.junit.jupiter.api.Test
    void testRemoveById() {
        repository.removeById(10);
        int size = repository.getSize();
        assertEquals(2, size);
        assertEquals(null, repository.getbyId(10));
        assertEquals(8, repository.getbyId(6).getNumber());
    }

    @org.junit.jupiter.api.Test
    void testRemoveByIndex() {
        assertEquals(8, repository.getbyIndex(1).get().getNumber());
        repository.removeByIndex(1);
        int size = repository.getSize();
        assertEquals(2, size);
        assertEquals(5, repository.getbyIndex(1).get().getNumber());

    }
}
