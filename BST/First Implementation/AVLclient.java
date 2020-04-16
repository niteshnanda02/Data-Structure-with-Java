package com.company.offline;

public class AVLclient {
    public static void main(String[] args) {
        AVL tree=new AVL();
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.display();
    }
}
