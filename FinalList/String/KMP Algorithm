package com.company.String;

import java.util.Arrays;
import java.util.Scanner;

public class kmpalgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.next(), pat = s.next();
        kmp(text, pat);
    }

    private static void kmp(String text, String pat) {
        int textLength = text.length(), patLength = pat.length();
        int[] lps = new int[patLength];
        create(pat, lps, patLength);
        System.out.println(Arrays.toString(lps));
        int i = 0, j = 0;
        while (i < textLength) {
            if (text.charAt(i)==pat.charAt(j)){
                j++;
                i++;
            }
            if(j==patLength){
                System.out.println("Found pattern at index "+(i-j));

                j=lps[j-1];
            }
            else if(i<textLength&&text.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }

    private static void create(String pat, int[] lps, int patLength) {
        int i = 1, j = 0;
        lps[0] = 0;
        while (i < patLength) {
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
                lps[i] = j ;
                i++;
            } else {
                if(j!=0){
                    j=lps[j-1];
                }else {
                    lps[i]=j;
                    i++;
                }
            }
        }
    }
}
