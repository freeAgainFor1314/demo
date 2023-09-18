package com.testwe.mobile.learn;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {18,0,17,5,6,46,4,37,48,94,15,48};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int k = partition(arr, l, r);
            quickSort(arr, l, k - 1);
            quickSort(arr, k + 1, r);
        }

    }

    private int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r + 1;
        int x = arr[i];
        while (true) {
            while (arr[++i] < x && i < r) ;
            while (arr[--j] > x) ;
            if (i >= j) break;
            swap(arr, i, j);
        }
        arr[l] = arr[j];
        arr[j] = x;
        return j;
    }


    private static void swap(int[] ary, int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
}
