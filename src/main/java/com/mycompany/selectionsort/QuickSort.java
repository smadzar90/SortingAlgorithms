/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.selectionsort;



import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author stipanmadzar
 */
public class QuickSort {

    public static int comparations = 0;
    public static int exchanges = 0;
    
    public static void quickSort(int[] array, int lowest, int highest) {
        
        if(lowest >= highest) {
            return;
        }
        
        int pivot = array[highest];
        
        int leftPointer = lowest;
        int rightPointer = highest;
        
        while(leftPointer < rightPointer) {
            
            while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
                comparations++;
        }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
                comparations++;
        }
              swap(array, leftPointer, rightPointer);
        }
        
        swap(array, leftPointer, highest);
        quickSort(array, lowest, leftPointer - 1);
        quickSort(array, leftPointer + 1, highest);
        
        
    }
    
    public static void swap(int[] array, int index1, int index2) {
        
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        exchanges++;
    }
   
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] array = new int[100000];
        Random rand = new Random();
        int size = array.length;
        
        for(int i = 0; i < 100000; ++i) {
            array[i] = rand.nextInt(10000) + 1;
        }
        
        System.out.println("\n->QUICK SORT\n");
        System.out.print("Unsorted array: ");      
        System.out.println(Arrays.toString(array));
        System.out.print("\nSorted array: ");
        quickSort(array, 0, size - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("\nArray size: " + size);
        System.out.println("Number of operations: " + (comparations + exchanges));
        System.out.println("Average time complexity: O(n*log n)\n\n");

        
        
    }
    
}
