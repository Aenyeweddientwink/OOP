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

}
