package com.company.recursion.questions;

import java.util.*;

public class Permutebychangingcase {
    public static void main(String[] args) {
        System.out.println(changeCase("a1b2",""));
    }

        private static List<String> changeCase(String ip, String op) {
            if(ip.isEmpty()){
                List<String> bs= new ArrayList<>();
                bs.add(op);
                return bs;
            }

            char cc=ip.charAt(0);
            String ros=ip.substring(1);
            char togglecc= (char) ((cc>='A'&&cc<='Z')?(cc-'A'+'a'):(cc-'a'+'A'));
            List<String> l1=changeCase(ros,op+cc);
            if((cc>='A'&&cc<='Z')||(cc>='a'&&cc<='z')) {
                List<String> l2 = changeCase(ros, op + togglecc);
                l1.addAll(l2);
            }

            return l1;
        }
}
