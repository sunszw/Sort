package com.study;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        Random ran = new Random();
        int[] arr = randomGeneration(0,10000000,100);

        System.out.println("排序前："+Arrays.toString(arr));

        long time = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long time1 = System.currentTimeMillis();

        System.out.println("快速排序："+Arrays.toString(arr));

        long time2 = System.currentTimeMillis();
        bublletSort(arr);
        long time3 = System.currentTimeMillis();

        System.out.println("冒泡排序："+Arrays.toString(arr));

        long quick = time1-time;
        long bubllet = time3-time2;
        System.out.println("快速排序用时："+quick);
        System.out.println("冒泡排序用时："+bubllet);
    }

    public static void quickSort(int[] arr, int low, int heigh) {
      if (left < right) {
            int i = left, j = right, base = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= base)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < base)
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = base;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    public static void bublletSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                int temp;
                if (arr[j] > arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static int[] randomGeneration(int min,int max,int n){
        if (n > ((max-min)+1) || min > max){
            return null;
        }

        int[] result = new int[n];
        int count =0;

        while(count < n) {
            int num = (int) (Math.random() * (max - min) + min);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (num == result[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }

        return result;
    }

}
