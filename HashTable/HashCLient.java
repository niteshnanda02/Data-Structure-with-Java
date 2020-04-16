package com.company.Online;

public class HashCLient {
    public static void main(String[] args) throws Exception {
        Hashtable<String,Integer> map=new Hashtable<>();
        map.put("Delhi",0);
        map.put("UP",1);
        map.put("Mumbai",2);
        map.put("Barut",4);
        map.display();
        System.out.println(map.get("Barut"));
    }
}
