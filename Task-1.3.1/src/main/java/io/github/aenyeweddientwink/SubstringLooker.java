package io.github.aenyeweddientwink;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

/**
 * This class finds a substring in the text
 */
public class SubstringLooker {
    /**
     * Searches the given substring in the given file.
     * For each line builds z function and adds substring occurrences to an array of indexes.
     *
     * @param substring substring to look for
     * @param in input file
     * @return list of all the occurrences of a given substring
     */
    public static List<Integer> search(String substring, InputStream in)
            throws NullPointerException, IOException {
        if (substring == null || in == null) {
            throw new NullPointerException();
        }
        int len = substring.length();

        if (len == 0) {
            return null;
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8));
        //zfunction of substring
        int[] zline = zfunction(substring.toCharArray(),substring.toCharArray(), new int [len], len);
        int pos = max(len, 512);
        char[] current = new char[pos];
        int offset = 0;
        int f = reader.read(current, offset, pos);
        //zfunction of a piece of text
        int[] zz = zfunction(current, substring.toCharArray(), zline, f);
        List<Integer> indexes = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < zz.length; i++) {
            if (zz[i] == len) {
                indexes.add(cnt, i);
                cnt++;
            }
        }

        offset += pos;
        char[] previous = new char[len];
        System.arraycopy(current, current.length - len, previous, 0, len);
        f = reader.read(current, 0, pos);
        char[] str;
        while (f > 0) {
            str = (String.valueOf(previous) + String.valueOf(current)).toCharArray();
            zz = zfunction(str, substring.toCharArray(), zline, f);
            System.arraycopy(current, current.length - len, previous, 0, len);

            for (int i = 0; i < zz.length; i++) {
                if (zz[i] == len && !indexes.contains(i + offset - len)) {
                    indexes.add(cnt, i + offset - len);
                    cnt++;
                }
            }

            offset += pos;
            f = reader.read(current, 0, pos);
        }
        return indexes;
    }

    /**
     * Builds the z function of a line using z function of the given substring.
     *
     * @param line line to build z function of
     * @param substr substring to look for
     * @param zline z function of a substring
     * @param n number of characters read
     * @return array of integers representing z function of a line
     */
    private static int[] zfunction(char[] line, char[] substr, int[] zline, int n) {
        int[] result = new int[line.length];
        int l = -1;
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (i < r) {
                result[i] = zline[i - l];
            } else {
                result[i] = 0;
            }
            // zz[i] < zline.length
            while (result[i] < substr.length
                    && i + result[i] < line.length && substr[result[i]] == line[i + result[i]]) {
                result[i]++;
            }
            if (i + result[i] > r) {
                l = i;
                r = i + result[i];
            }
        }
        return result;
    }


}