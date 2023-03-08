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
public class MergeSort {

    static int comparations = 0;
    public static int exchanges = 0;
    
    public static void mergeSort(ArrayList<Integer> list) {
        
        int size = list.size();
        
        if(size < 2) {
            return;
        }
        
        int midPoint = size / 2;
        ArrayList<Integer> leftSide = new ArrayList<Integer>(midPoint);
        ArrayList<Integer> rightSide = new ArrayList<Integer>(size - midPoint);
        
        for(int i = 0; i < midPoint; i++) {
            leftSide.add(list.get(i));
        }
        
        for(int n = midPoint; n < size; n++) {
            rightSide.add(list.get(n));
        }
        
        mergeSort(leftSide);
        mergeSort(rightSide);
        merge(list, leftSide, rightSide);
        
    }
    
    public static void merge(ArrayList<Integer> list, ArrayList<Integer> leftSide, ArrayList<Integer> rightSide) {
        
        int leftSize = leftSide.size();
        int rightSize = rightSide.size();
        
        int ls = 0, rs = 0, li = 0;
        
        
        while(ls < leftSize && rs < rightSize) {
            
            if(leftSide.get(ls) <= rightSide.get(rs)) {
                list.set(li, leftSide.get(ls));
                ls++;
                exchanges++;
            }
            else {
                list.set(li, rightSide.get(rs));
                rs++;
                exchanges++;
            }
           li++;
           comparations++;
        }
        
        while(ls < leftSize) {
            list.set(li, leftSide.get(ls));
            li++; 
            ls++;    
            exchanges++;
        }
        
        while(rs < rightSize) {
            list.set(li, rightSide.get(rs));
            rs++;
            li++;  
            exchanges++;
        }
             
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        
        for(int i = 0; i < 100000; ++i) {
            list.add(rand.nextInt(1000) + 1);   
        }
        
        System.out.println("\n->MERGE SORT\n");
        System.out.print("Unsorted list: ");
        System.out.println(list);
        mergeSort(list);
        System.out.print("\nSorted list: ");
        System.out.println(list);
        System.out.println("\nList size: " + list.size());
        System.out.println("Number of operations: " + (comparations + exchanges));
        System.out.println("Average time complexity: O(n*log n)\n\n");
        
    }
}
