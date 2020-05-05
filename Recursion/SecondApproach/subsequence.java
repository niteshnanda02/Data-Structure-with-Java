package com.company.online;

import java.util.ArrayList;

public class subsequence {
    public static void main(String[] args) {
        String s="abc";
       System.out.println(getssAscii(s));
    }

    private static ArrayList<String> getss(String s) {
        if (s.length()==0){
            ArrayList<String> BaseList=new ArrayList<>();
            BaseList.add("");
            return BaseList;
        }
        char cc=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String> myResult=new ArrayList<>();
        ArrayList<String> recResult=getss(ros);
        for (int i = 0; i <recResult.size() ; i++) {
            myResult.add(recResult.get(i));
            myResult.add(cc+recResult.get(i));
        }
        return myResult;
    }
    private static ArrayList<String> getssAscii(String s) {
        if (s.length()==0){
            ArrayList<String> BaseList=new ArrayList<>();
            BaseList.add("");
            return BaseList;
        }
        char cc=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String> myResult=new ArrayList<>();
        ArrayList<String> recResult=getssAscii(ros);
        for (int i = 0; i <recResult.size() ; i++) {
            myResult.add(recResult.get(i));
            myResult.add(cc+recResult.get(i));
            myResult.add((cc-0)+recResult.get(i));
        }
        return myResult;
    }


}
