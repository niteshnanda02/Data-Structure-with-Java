package com.company.offline;

public class Client {
    public static void main(String[] args) {
        binarytree tree=new binarytree();
        tree.populate("5 true 10 true 15 false false false true 20 false false");
        tree.display();
        System.out.println(tree.height());
    }
}
