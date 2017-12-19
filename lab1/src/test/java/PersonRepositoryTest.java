import org.joda.time.LocalDate;
import ru.vsu.entities.Person;
import ru.vsu.repositories.PersonRepository;
import ru.vsu.sorters.InsertionSorter;
import ru.vsu.sorters.BubbleSorter;
import ru.vsu.sorters.SelectionSorter;



import org.junit.Before;

import org.junit.Test;




import static org.junit.Assert.*;

public class PersonRepositoryTest {

    private Person myPerson;
    private Person myFriend;
    private Person myTestPerson1;
    private Person myTestPerson2;
    private Person myTestPerson3;
    private Person myTestPerson5;

    @Before
    public void initData(){
        myPerson=new Person(new LocalDate(1996,03,14),"Belonogova");
        myFriend=new Person(new LocalDate(1995,12,8),"Voronkov");
        myTestPerson1=new Person(new LocalDate(2004,02,21),"Morozov");
        myTestPerson2=new Person(new LocalDate(1972,06,28),"Ivanov");
        myTestPerson3=new Person(new LocalDate(1952,10,12),"Petrov");
        myTestPerson5=new Person(new LocalDate(1972,06,28),"Gusev");
    }

    @Test
    public void testSize(){
        PersonRepository repository = new PersonRepository();
        repository.add(myPerson);
        assertTrue(repository.getKol() == 1);
    }

    @Test
    public void testIsEmpty(){
        PersonRepository repository = new PersonRepository();
        assertTrue(repository.isEmpty());
    }

    @Test
    public void testAdd(){
        PersonRepository actual = new PersonRepository();
        actual.add(myPerson);
        actual.add(myFriend);
        actual.add(myTestPerson1);

        PersonRepository expected = new PersonRepository();
        expected.add(myPerson);
        expected.add(myFriend);
        expected.add(myTestPerson1);

        assertArrayEquals(actual.getAll(),expected.getAll());
    }

    @Test
    public void testGet(){
        PersonRepository actual = new PersonRepository();
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);

        assertEquals(actual.get(1),myTestPerson2);
    }

    @Test
    public void testSet(){
        PersonRepository actual = new PersonRepository();
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);
        actual.set(1, myPerson);

        PersonRepository expected = new PersonRepository();
        expected.add(myTestPerson1);
        expected.add(myPerson);
        expected.add(myTestPerson3);

        assertArrayEquals(actual.getAll(),expected.getAll());
    }

    @Test
    public void testContains(){
        PersonRepository actual = new PersonRepository();
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);

        assertTrue(actual.contains(myTestPerson3));
    }



    @Test
    public void testIndexOf(){
        PersonRepository actual = new PersonRepository();
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);

        assertEquals(actual.indexOf(myTestPerson3),2);
    }

    @Test
    public void testBubbleSortById(){
        PersonRepository actual = new PersonRepository();
        actual.setSorter(new BubbleSorter());
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);
        actual.add(myPerson);
        actual.sortByFam();

        PersonRepository expected = new PersonRepository();
        expected.add(myPerson);
        expected.add(myTestPerson2);
        expected.add(myTestPerson1);
        expected.add(myTestPerson3);

        assertArrayEquals(actual.getAll(),expected.getAll());
    }

    @Test
    public void testInsertionSortByName(){
        PersonRepository actual = new PersonRepository();
        actual.setSorter(new InsertionSorter());
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);
        actual.add(myPerson);
        actual.sortByFam();

        PersonRepository expected = new PersonRepository();
        expected.add(myPerson);
        expected.add(myTestPerson2);
        expected.add(myTestPerson1);
        expected.add(myTestPerson3);

        assertArrayEquals(actual.getAll(),expected.getAll());
    }

    @Test
    public void testSelectionSortByDOB(){
        PersonRepository actual = new PersonRepository();
        actual.setSorter(new SelectionSorter());
        actual.add(myTestPerson1);
        actual.add(myTestPerson2);
        actual.add(myTestPerson3);
        actual.add(myPerson);
        actual.sortByDOB();

        PersonRepository expected = new PersonRepository();
        expected.add(myTestPerson3);
        expected.add(myTestPerson2);
        expected.add(myPerson);
        expected.add(myTestPerson1);

        assertArrayEquals(actual.getAll(),expected.getAll());
    }


    @Test
    public void testSearchByFIO(){
        PersonRepository personRepository = new PersonRepository();
        personRepository.add(myTestPerson1);
        personRepository.add(myTestPerson2);
        personRepository.add(myTestPerson3);
        personRepository.add(myFriend);

        PersonRepository expected = new PersonRepository();
        expected.add(myTestPerson2);

        PersonRepository found = personRepository.searchByFam("Ivanov");

        assertArrayEquals(found.getAll(),expected.getAll());
    }

    @Test
    public void testSearchByDOB(){
        PersonRepository personRepository = new PersonRepository();
        personRepository.add(myPerson);
        personRepository.add(myFriend);
        personRepository.add(myTestPerson2);
        personRepository.add(myTestPerson5);

        PersonRepository expected = new PersonRepository();
        expected.add(myTestPerson2);
        expected.add(myTestPerson5);

        PersonRepository found = personRepository.searchByDOB(new LocalDate(1972,06,28));

        assertArrayEquals(found.getAll(),expected.getAll());
    }

}
