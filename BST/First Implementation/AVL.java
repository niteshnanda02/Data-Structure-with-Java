package com.company.offline;

public class AVL {
    private class Node {
        int data;
        Node left, right;
        int height;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data > data) {
            node.left = insert(node.left, data);
        }
        if (node.data < data) {
            node.right = insert(node.right, data);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        if (balance(node) < -1 && balance(node.right) < 0) {
            return leftRotate(node);
        } else if (balance(node) > 1 && balance(node.left) > 0) {
            return righRotate(node);
        } else if (balance(node) < -1 && balance(node.right) > 0) {
            node.right = righRotate(node.right);
            return leftRotate(node);
        } else if (balance(node) > 1 && balance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return righRotate(node);
        }
        return node;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    public int balance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public Node leftRotate(Node node) {
        //before
        Node x = node;
        Node y = x.right;
        Node t2 = y.left;

        //after
        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public Node righRotate(Node node) {
        Node x = node;
        Node y = x.left;
        Node t2 = y.right;

        y.right = x;
        x.left = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
}
