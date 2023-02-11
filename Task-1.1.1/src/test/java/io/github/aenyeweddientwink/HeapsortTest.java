package io.github.aenyeweddientwink;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Class with Tests for Heapsort class.
 */
public class HeapsortTest {
    @Test
    void testSorted(){
        int[] arr = {1,2,3};
        int[] result = {1,2,3};
        Heapsort.sort(arr);
        assertArrayEquals(result,arr);
    }
    @Test
    void testReverse(){
        int[] arr = {5,4,3,2,1};
        int[] result = {1,2,3,4,5};
        Heapsort.sort(arr);
        assertArrayEquals(result,arr);
    }
    @Test
    void testRandomNumbers(){
        Random random = new Random();

        int[] arr = new int[1000000];
        int[] result = new int[1000000];
        for (int i  = 0; i < 1000000; i++){
            arr[i] =random.nextInt();
            result[i] = arr[i];
        }
        Arrays.sort(result);
        Heapsort.sort(arr);
        assertArrayEquals(result,arr);

    }
}
