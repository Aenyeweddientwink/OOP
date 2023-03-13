package io.github.aenyeweddientwink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Class Main for using the Calculator in the console
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String expression = input.readLine();
        System.out.println(Calculator.calculate(Arrays.asList(expression.split(" "))));
    }
}