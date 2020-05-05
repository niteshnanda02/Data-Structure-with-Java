package com.company.offline;

import java.util.ArrayList;

public class subseq {
    public static void main(String[] args) {
//        subsequence("","abc");
//        System.out.println(subsequenceList("","abc"));
//    ascii("","abc");
//        System.out.println(asciilist("", "abc"));
//    permutation("","abc");
        numpad("", "8");
    }

    private static void subsequence(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        subsequence(processed, unprocessed);
        subsequence(processed + ch, unprocessed);
    }

    private static ArrayList subsequenceList(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList list = new ArrayList();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        ArrayList L1 = subsequenceList(processed, unprocessed);
        ArrayList L2 = subsequenceList(processed + ch, unprocessed);
        L1.add(L2);
        return L1;
    }

    private static void ascii(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        ascii(processed, unprocessed);
        ascii(processed + ch, unprocessed);
        ascii(processed + (ch - 0), unprocessed);
    }

    private static ArrayList asciilist(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList list = new ArrayList();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        ArrayList L1 = asciilist(processed, unprocessed);
        ArrayList L2 = asciilist(processed + ch, unprocessed);
        ArrayList L3 = asciilist(processed + (ch - 0), unprocessed);
        L2.add(L3);
        L1.add(L2);
        return L1;
    }

    public static void permutation(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        unprocessed = unprocessed.substring(1);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);
            permutation(first + ch + second, unprocessed);

        }
    }

    public static void numpad(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '1';
        unprocessed = unprocessed.substring(1);
        for (int i = 3 * (digit - 1); i < 3 * digit; i++) {
            if (i == 26) {
                continue;
            }
            char ch = (char) (i + 'a');
            numpad(processed + ch, unprocessed);
        }

    }

    public static ArrayList numpadlist(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList List = new ArrayList();
            List.add(processed);
            return List;
        }
        int digit = unprocessed.charAt(0) - '0';
        unprocessed = unprocessed.substring(1);
        ArrayList List = new ArrayList();
        for (int i = 3 * (digit - 1); i < 3 * digit; i++) {
            if (i == 26) {
                continue;
            }
            char ch = (char) (i + 'a');
            List.addAll(numpadlist(processed+ch,unprocessed));
        }
        return List;

    }

}
