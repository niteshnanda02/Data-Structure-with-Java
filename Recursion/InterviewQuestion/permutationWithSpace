package com.company.recursion.questions;

public class permutationWithSpac {
    public static void main(String[] args) {
        space("abc", "");
    }

    private static void space(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }

        char cc = ip.charAt(0);
        String ros = ip.substring(1);
        if (!op.isEmpty())
            space(ros, op + " " + cc);
        space(ros, op + cc);

    }
}
