import org.joda.time.LocalDate;
import org.junit.Test;
import ru.vsu.lab1.Person;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testGetAge() {
        Person myPerson=new Person(new LocalDate(1996,03,14),"Belonogova");
        assertEquals(21, myPerson.getAge());
    }
}