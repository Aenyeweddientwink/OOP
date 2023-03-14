package io.github.aenyeweddientwink;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for calculator
 */
public class CalculatorTest {

    @Test
    void exceptionTest(){
        assertThrows(NullPointerException.class, () -> Calculator.calculate(null));
    }
    @Test
    void simpleTest() throws IOException {
        List<String> expression1= new ArrayList<>(Arrays.asList("1"));
        List<String> expression2 = new ArrayList<>(Arrays.asList("+","sin","1"));
        List<String> expression3 = new ArrayList<>(Arrays.asList("-","1","1"));
        List<String> expression4 = new ArrayList<>(Arrays.asList("*","2","2"));
        List<String> expression5 = new ArrayList<>(Arrays.asList("/","3","3"));
        List<String> expression6 = new ArrayList<>(Arrays.asList("/","3","0"));
        List<String> expression7 = new ArrayList<>(Arrays.asList("sin"));
        assertEquals(1.0,Calculator.calculate(expression1));
        assertThrows(IOException.class,()-> Calculator.calculate(expression2));
        assertEquals(0.0,Calculator.calculate(expression3));
        assertEquals(4.0,Calculator.calculate(expression4));
        assertEquals(1.0,Calculator.calculate(expression5));
        assertThrows(IllegalArgumentException.class,()->Calculator.calculate(expression6));
        assertThrows(IOException.class,()-> Calculator.calculate(expression7));
    }

    @Test
    void complicatedoperationsTest() throws IOException {
        List<String> expression1= new ArrayList<>(Arrays.asList("sin","+","-","1","2","1"));
        List<String> expression2= new ArrayList<>(Arrays.asList("pow","2","5"));
        List<String> expression3= new ArrayList<>(Arrays.asList("+","cos","0","1"));
        List<String> expression4= new ArrayList<>(Arrays.asList("sqrt","1024"));
        List<String> expression5= new ArrayList<>(Arrays.asList("log","5","25"));
        List <String> expression6 = new ArrayList<>(Arrays.asList("log","sqrt","+","1","3","4"));
        assertEquals(0.0,Calculator.calculate(expression1));
        assertEquals(32.0,Calculator.calculate(expression2));
        assertEquals(2.0,Calculator.calculate(expression3));
        assertEquals(32.0,Calculator.calculate(expression4));
        assertEquals(2.0,Calculator.calculate(expression5));
        assertEquals(2.0,Calculator.calculate(expression6));
    }

    @Test
    void logTest(){
        List<String> expression1= new ArrayList<>(Arrays.asList("log","1","1"));
        List<String> expression2= new ArrayList<>(Arrays.asList("log","1","0"));
        assertThrows(IllegalArgumentException.class,()->Calculator.calculate(expression1));
        assertThrows(IllegalArgumentException.class,()->Calculator.calculate(expression2));

    }
}
