package io.github.aenyeweddientwink;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


/**
 * Class Heapsort implements sorting an int array with a heap sort.
 */
public class Heapsort
{
    /**
     * Sorts array with the heap sort algorithm.
     * @param arr array to sort
     */
    public static void sort(int[] arr){
        int n = arr.length;
        //building max heap
        int i = n/2 -1;
        while (i>=0)
        {
            heapify(arr,i--,n);
        }
        //building our sorted array
        for (int j = n - 1;  j > 0; j--){
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            heapify(arr,0,j);
        }

    }

    /**
     * Supporting function. Should not be used outside this class methods.
     * @param arr array to be heapified.
     * @param i index of the parent which is being inspected to be rebalanced
     * @param n size of an array
     */
    private static void heapify(int[] arr,int i, int n){
        int l = i*2 + 1; // left child
        int r = i*2 + 2; // right child
        int maxindex = i;

        if ((l <n) && (arr[l] > arr[maxindex]))
            maxindex = l;
        if ((r < n) && (arr[r] > arr[maxindex]))
            maxindex = r;

        if (i!= maxindex){
            int temp = arr[i];
            arr[i] = arr[maxindex];
            arr[maxindex] = temp;

            heapify(arr,maxindex,n);
        }
    }
}