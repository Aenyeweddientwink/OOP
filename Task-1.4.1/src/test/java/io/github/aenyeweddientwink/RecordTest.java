package io.github.aenyeweddientwink;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the RecordBook and Record classes
 */
public class RecordTest {
    @Test void RecordTest1(){
        Record Record1 = new Record("Math", "Petrov",5,1);
        assertEquals("Math",Record1.subject);
        assertEquals("Petrov",Record1.teacher);
        assertEquals(5,Record1.mark);
        assertEquals(1,Record1.semester);
    }
    @Test void RecordBookTest1(){
        RecordBook Book1 = new RecordBook("Petr","Petrov",1);
        Book1.addRecord("Math","Ivanov",5,1);
        Book1.addRecord("PE","Morozov",5,1);
        Book1.changeSemester(2);
        assertEquals(2,Book1.getSemester());
        assertEquals(true,Book1.isAbletogetIncreasedStipend());
        assertEquals(true,Book1.isAbletofinishwithHonors());
    }

    @Test
    public void MyTest(){
        RecordBook Mybook = new RecordBook("Artyom","Solovev",1);
        Mybook.addRecord("ImperativeProgramming","Nesterenko",3,1);
        Mybook.addRecord("PE","Mamekov",5,1);
        Mybook.addRecord("DeclarativeProgramming","Vlasov",5,1);
        Mybook.addRecord("Calculus","Rudometova",4,1);

        Mybook.changeSemester(2);

        Mybook.addRecord("ImperativeProgramming","Nesterenko",3,2);
        Mybook.addRecord("PE","Mamekov",5,2);
        Mybook.addRecord("DeclarativeProgramming","Vlasov",4,2);
        Mybook.addRecord("Calculus","Rudometova",4,2);

        assertEquals(2,Mybook.getSemester());
        assertEquals(false,Mybook.isAbletogetIncreasedStipend());
        assertEquals(false,Mybook.isAbletofinishwithHonors());
        assertEquals((float) 17/4, Mybook.SemesterAverageMark(1));
        assertEquals((float) 33/8,Mybook.AlltimeaverageMark());
    }
}
