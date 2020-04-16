package com.company.offline;

import java.util.Scanner;

public class binarytree {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(String line) {
        Scanner s = new Scanner(line);
        System.out.println("enter root value");
        int value = s.nextInt();
        this.root = new Node(value);
        populate(root, s);
    }

    private void populate(Node node, Scanner s) {
        System.out.println("want to add left value");
        boolean left = s.nextBoolean();
        if (left) {
            System.out.println("enter the left value of" + node.value);
            int value = s.nextInt();
            node.left = new Node(value);
            node.left.parent = node;
            populate(node.left, s);
        }
        System.out.println("want to add right value");
        boolean right = s.nextBoolean();
        if (right) {
            System.out.println("enter the right value of" + node.value);
            int value = s.nextInt();
            node.right = new Node(value);
            node.right.parent = node;
            populate(node.right, s);
        }

    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + '\t');
        display(node.right, indent + '\t');
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        int height = Math.max(left, right) + 1;
        return height;
    }
    public int diameter(){
        return height(root.left)+height(root.right)+1;
    }
    public boolean exist(int item){
        return exist(this.root,item);
    }

    private boolean exist(Node node, int item) {
        if (node==null){
            return false;
        }
        if (node.value==item){
            return true;
        }
        return exist(node.left,item)||exist(node.right,item);
    }


}
