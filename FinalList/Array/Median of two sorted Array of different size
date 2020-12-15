package com.company.Array.Questions;

import java.util.Scanner;

public class MedianTwoSortedArray {
    public static void main(String[] args) {
        int[] a1={2, 3, 5, 8},a2={10, 12, 14, 16, 18, 20};
        System.out.println(findmedian(a1,a2));
    }

    private static double findmedian(int[] a1, int[] a2) {

        if(a1.length>a2.length)
            return findmedian(a2,a1);
        int X=a1.length,Y=a2.length;
        int low=0,high=a1.length;
        while (low<=high){
            int partitionX=(low+high)/2;
            int partitionY=(X+Y+1)/2-partitionX;

            int maxLeftX=(partitionX==0)?Integer.MIN_VALUE:a1[partitionX-1];
            int minRightX=(partitionX==X)?Integer.MAX_VALUE:a1[partitionX];

            int maxLeftY=(partitionY==0)?Integer.MIN_VALUE:a2[partitionY-1];
            int minRightY=(partitionY==Y)?Integer.MAX_VALUE:a2[partitionY];

            if(maxLeftX<=minRightY&&maxLeftY<=minRightX){
                if((X+Y)%2==0){
                    return ((double) Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
                }else {
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX>minRightY){
                high=partitionX-1;
            }else if(maxLeftY>minRightX){
                low=partitionX+1;
            }
        }
        return -1;
    }
}
