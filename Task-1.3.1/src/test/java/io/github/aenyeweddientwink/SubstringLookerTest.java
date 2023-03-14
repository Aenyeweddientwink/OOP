package io.github.aenyeweddientwink;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * This class is tests for a SubstringLooker class
 */
public class SubstringLookerTest {

    @Test
    public void exceptionTest() {
        String path = "/Test1.txt";
        assertThrows(NullPointerException.class, () -> SubstringLooker.search(null, SubstringLooker.class.getResourceAsStream(path)));
        assertThrows(NullPointerException.class, () -> SubstringLooker.search("Hi", null));
    }

    @Test
    public void test2() throws IOException {
        String path = "/Test2.txt";
        InputStream in = SubstringLooker.class.getResourceAsStream(path);
        List<Integer> indexes = SubstringLooker.search("abc", in);
        List<Integer> test = List.of(0,5,10);
        assertEquals(3, indexes.size());
        assertEquals(test, indexes);
        in.close();

    }


}
