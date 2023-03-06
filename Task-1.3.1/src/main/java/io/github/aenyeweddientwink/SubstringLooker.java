package io.github.aenyeweddientwink;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.InputStream;
/**
 * This class finds a substring in the text
 */
public class SubstringLooker {


    /**
     * This method returns a prefix function for the given sample
     * @param sample Size should be bigger than 0
     * @return
     */
    static int[] prefixFunction(String sample){
        int length =sample.length();
        int[] table = new int[length];
        if (length ==1){
            table[0] = 0;
            return table;
        }
        for (int i = 1; i < length; i++){
            int j = 0;
            while (i+j < length && sample.charAt(j) == sample.charAt(i+j)){
                table[i+j] = Math.max(table[i+j], j+1);
                j++;
            }
        }
        return table;
    }

    /**
     * This method searches for a substring in the text
     * @param text Text
     * @param substring Substring which is to be founded
     * @return
     */
    public static ArrayList<Integer> Lookforsubstring(String text, String substring){
        ArrayList<Integer> result = new ArrayList<>();
        int[] prefixTable = prefixFunction(substring);
        int j = 0;
        int i =0;
        int textLength = text.length();
        int substringLength = substring.length();
        while (i < textLength){
            if (substring.charAt(j) == text.charAt(i)){
                j++;
                i++;
            }
            if (j == substringLength){
                result.add(i-j);
                j=prefixTable[j-1];
            }
            else if (i <textLength && substring.charAt(j) != text.charAt(i)){
                if (j!=0){
                    j = prefixTable[j-1];
                }
                else {
                    i = i+1;
                }
            }
        }
        return result;
    }

}