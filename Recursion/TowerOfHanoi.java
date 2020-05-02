package com.company;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        check(n,'A','C','B');

    }
    public static void check(int n,char src,char dest,char helper){
        //base case
        if(n==0)
            return;

        //recursive call
        check(n-1,src,helper,dest);

        System.out.println("Move "+n +" from "+src+" to "+dest);

        check(n-1,helper,dest,src);
    }
}
