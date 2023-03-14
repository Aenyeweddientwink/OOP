package io.github.aenyeweddientwink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the RecordBook and Record classes
 */
public class RecordTest {

    @Test void ExceptionTest1(){
        Record Record1 = new Record("Math","Petrov", Record.Credit.PASSED,1);
        assertThrows(NullPointerException.class,()->Record1.getMark());
    }

    @Test void RecordTest1(){
        Record Record1 = new Record("Math", "Petrov",5,1);
        assertEquals(5,Record1.getMark());
        assertEquals(1,Record1.getSemester());
    }
    @Test void RecordBookTest1(){
        RecordBook Book1 = new RecordBook("Petr","Petrov",1);
        Record Record1 = new Record("English","Pavlov",5,1);
        Book1.addRecord(Record1);
        Book1.addRecord("Math","Ivanov",5,1);
        Book1.addRecord("PE","Morozov", Record.Credit.PASSED,1);
        Book1.changeSemester(2);
        Book1.setQualificationScore(5);
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
