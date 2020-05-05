package com.company.offline;

public class Boardpath {
    public static void main(String[] args) {
        printBoard(0,9,"");
//        System.out.println(countBoard(0,10));
    }
    public static void printBoard(int cur,int end,String processed){
        if (cur==end){
            System.out.println(processed);
            return;
        }
        if (cur>end){
            return;
        }
        for (int dice = 1; dice <=6 ; dice++) {
            printBoard(cur+dice,end,processed+dice);
        }
    }
    public static int countBoard(int cur,int end){
        if (cur==end){

            return 1;
        }
        if (cur>end){
            return 0;
        }
        int count=0;
        for (int dice = 1; dice <=6 ; dice++) {
            count+=countBoard(cur+dice,end);
        }
        return count;
    }
}
