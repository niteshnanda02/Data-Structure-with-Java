package com.company.offline;

public class perm {
    public static void main(String[] args) {
        permutation("","abc");

    }
    public static void permutation(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        for (int i = 0; i < unprocessed.length(); i++) {
            char ch = unprocessed.charAt(i);
            String un = unprocessed.substring(0, i) + unprocessed.substring(i + 1);
            permutation(processed + ch, un);
        }
    }

}
