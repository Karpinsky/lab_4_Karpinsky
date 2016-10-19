package com.karpinsky.csucu.Lab_4_git;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] main)
    {
        Integer[] newArr = {32, 5124, 321, 52, 3};
        System.out.println(Arrays.toString(SortMerge(newArr)));
    }

    @SuppressWarnings("rawtypes")
    public static Comparable[] SortMerge(Comparable[] arr)
    {
        if (arr.length <= 1)
        {
            return arr;
        }

        Comparable[] leftArr = new Comparable[arr.length / 2];
        Comparable[] rightArr = new Comparable[arr.length - leftArr.length];

        System.arraycopy(arr, 0, leftArr, 0, leftArr.length);
        System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);

        leftArr = SortMerge(leftArr);
        rightArr = SortMerge(rightArr);

        int leftIndex = 0;
        int rightIndex = 0;
        int finalIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length)
        {
            if (leftArr[leftIndex].compareTo(rightArr[rightIndex]) <= 0)
            {
                arr[finalIndex] = leftArr[leftIndex];
                leftIndex++;
            }
            else
            {
                arr[finalIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            finalIndex++;
        }

        System.arraycopy(leftArr, leftIndex, arr, finalIndex, leftArr.length - leftIndex);
        System.arraycopy(rightArr, rightIndex, arr, finalIndex, rightArr.length - rightIndex);

        return arr;
    }

}
