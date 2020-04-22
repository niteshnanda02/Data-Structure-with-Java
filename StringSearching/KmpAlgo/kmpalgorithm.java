package com.company.Online;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class kmpalgorithm {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String T= scanner.next();
        String P = scanner.next();
        check(T,P);
    }
    private static void check(String T,String P){
        int t=T.length();
        int p=P.length();
        int[] parr=new int[p];
        create(P,p,parr);
        int i=0,j=-1;
        while (i<t){
            if(T.charAt(i)==P.charAt(j+1)){
                if(j+1==p-1){
                    int ans=i-j;
                    System.out.println("String is at index "+ans);
                    return;
                }else {

                    i++;
                    j++;
                }
            }else if(j+1>0){
                j=parr[j];
            }else {
                i++;
            }
        }
    }
    private static void create(String P,int p,int[] parr){
        int i=1,j=0;
        parr[0]=0;
        while (i<p){
            if(P.charAt(i)==P.charAt(j)){
                parr[i]=j+1;
                j++;
                i++;
            }else if(j>0)
                j=parr[j-1];
            else
                i++;
        }
    }
}
