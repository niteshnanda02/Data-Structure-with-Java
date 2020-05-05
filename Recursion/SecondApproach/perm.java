package com.company.online;

import java.util.ArrayList;

public class perm {
    public static void main(String[] args) {
        System.out.println(getpermutation("abc"));
    }
    public static ArrayList<String> getpermutation(String str){
        if (str.length()==0){
            ArrayList<String> br=new ArrayList<>();
            br.add("");
            return br;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        //recursion result
        ArrayList<String> rr=getpermutation(ros);
        //my result
        ArrayList<String> mr=new ArrayList<>();
            for (String rrs:rr) {
            for (int i = 0; i <=rrs.length() ; i++) {
                String val =rrs.substring(0,i)+cc+rrs.substring(i);
                mr.add(val);
            }
        }
        return mr;

    }
}
