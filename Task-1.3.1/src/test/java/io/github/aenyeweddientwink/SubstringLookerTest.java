package io.github.aenyeweddientwink;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * This class is tests for a SubstringLooker class
 */
public class SubstringLookerTest {
    @Test
    void simpleTest(){
        String text1 = "1231";
        String substring1 ="1";
        ArrayList<Integer> result= new ArrayList<Integer>();
        result.add(0);
        result.add(3);
        assertEquals(SubstringLooker.Lookforsubstring(text1,substring1),result);
    }

    @Test
    void hardTest(){
        String text1 = "21211232121212112332132121123212121211233213212112321212121123321321211232121212112332132121123212121211233213";
        String substring1 = "2121";
        ArrayList<Integer> result= new ArrayList<Integer>();
        for  (int i = 0; i< 5;i++) {
            result.add(0+22*i);
            result.add(7+22*i);
            result.add(9+22*i);
            result.add(11+22*i);
        }
        assertEquals(SubstringLooker.Lookforsubstring(text1,substring1),result);
    }


}
