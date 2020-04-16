package com.company.Online;

import java.security.Key;
import java.util.*;

public class HashmapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Delhi", 100);
        map.put("UP", 10);
        map.put("Barut", 150);
        map.put("UK", 140);
        System.out.println(map);
        System.out.println(map.get("Barut"));
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + " ");
        }
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.print(value + " ");
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        String str = "aabbccaad";
        System.out.println(getmaxfreq(str));
        int[] one = {1, 2, 3, 4};
        int[] two = {2, 3, 4, 5};
        ArrayList<Integer> list = getintersection(one, two);
        System.out.println(list);
    }

    private static ArrayList<Integer> getintersection(int[] one, int[] two) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < one.length; i++) {
            map.put(one[i], false);
        }
        for (int i = 0; i < two.length; i++) {
            if (map.containsKey(two[i])) {
                map.put(two[i], true);
            }
        }
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            if (entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static char getmaxfreq(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            if (map.containsKey(cc)) {
                int ov = map.get(cc);
                int nv = ov + 1;
                map.put(cc, nv);
            } else {
                map.put(cc, 1);
            }
        }
        char maxchar = '\0';
        int max = 0;
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxchar = entry.getKey();
            }
        }
        return maxchar;
    }
}
