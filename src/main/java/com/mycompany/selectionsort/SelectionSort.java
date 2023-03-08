/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.selectionsort;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author stipanmadzar
 */
public class SelectionSort {

    static long comparations = 0;
    static long exchanges = 0;
    
    public static void selectionSort(ArrayList<Integer> list) {
        
        int minValue, minIndex, temp;
        
        for(int i = 0; i < list.size() - 1; ++i) {
            
            minIndex = i;
            minValue = list.get(i);
            
            for(int n = i + 1; n < list.size(); ++n) {
                
                if(list.get(n) < minValue) {
                    minValue = list.get(n);
                    minIndex = n;
                }
                comparations++;
            }
            
            if(minIndex != i) {
                temp = list.get(i);
                list.set(i, minValue);
                list.set(minIndex, temp);
                exchanges++;
            }
            
            
        }    
        
    }
    
    
    public static void main(String[] args) {
        
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        
        for(int i = 0; i < 100000; ++i) {
            list.add(rand.nextInt(1000) + 1);   
        }
        
        System.out.println("\n->SELECTION SORT\n");
        System.out.print("Unsorted list: ");
        System.out.println(list);
        System.out.print("\nSorted list: ");
        selectionSort(list);
        System.out.println(list);
        System.out.println("\nList size: " + list.size());
        System.out.println("Number of operations: " + (comparations + exchanges));
        System.out.println("Average time complexity: O(n^2)\n\n");

   }
        
}

