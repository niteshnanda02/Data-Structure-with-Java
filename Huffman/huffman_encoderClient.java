package com.company.Online;

public class huffman_encoderClient {
    public static void main(String[] args) {
        huffman_encoder h=new huffman_encoder("nitesh");
        String codeString=h.encode("nitesh");
        System.out.println(codeString);
        System.out.println(h.decode(codeString));
    }
}
