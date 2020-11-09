package com.company.recursion.questions;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class printAllSubsequences {
    static Set<String> set=new TreeSet<>();
    public static void main(String[] args) {
        set.clear();
        subsequence("abc","");
        System.out.println(set);
    }
    //IP-OP method
    private static void subsequence(String ip, String op) {
        //base case
        if(ip.isEmpty()){
            set.add(op);
            return;
        }

        char cc=ip.charAt(0);
        String ros=ip.substring(1);
        subsequence(ros,op);
        subsequence(ros,op+cc);
    }
}

