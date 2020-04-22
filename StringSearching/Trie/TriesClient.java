package com.company.Online;

public class TriesClient {
    public static void main(String[] args) {
        Tries tries=new Tries();
        tries.addWord("arts");
        tries.addWord("art");
        tries.addWord("bug");
        tries.addWord("boy");
        tries.addWord("sea");
        tries.addWord("seen");
        tries.addWord("sea");
        tries.addWord("amit");
        tries.display();
//        System.out.println(tries.search("bug"));
//        tries.remove("art");
//        tries.display();

    }
}
