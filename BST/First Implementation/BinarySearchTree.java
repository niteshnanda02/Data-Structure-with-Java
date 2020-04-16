package com.company.offline;

public class BinarySearchTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int count;

        public Node(int value) {
            this.value = value;
            this.count = 1;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            this.root = new Node(value);
            return;
        }
        insert(root, value);
    }

    private void insert(Node node, int value) {
        if (node.value == value) {
            node.count++;
            return;
        }
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        }
        if (node.value < value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void populate(int[] data) {
        populate(data, 0, data.length - 1);
    }

    private void populate(int[] data, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        insert(data[mid]);
        populate(data, start, mid - 1);
        populate(data, mid + 1, end);
    }

    public void range(Node node, int k1, int k2) {
        if (node == null) {
            return;
        }
        if (node.value >= k1 && node.value <= k2) {
            System.out.println(node.value);
        }
        range(node.left, k1, k2);
        range(node.right, k1, k2);
    }

    public int smallest() {
        return smallest(this.root);
    }

    public int succesor(Node node) {
        return smallest(node.right);
    }

    private int smallest(Node node) {
        if (node.left == null) {
            return node.value;
        }
        return smallest(node.left);
    }

    public boolean isBST() {
        return isBST(this.root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBST(Node node, int max, int min) {
        if (node == null) {
            return true;
        }
        if (node.value >= max || node.value <= min) {
            return false;
        }
        return isBST(node.left, node.value, min) && isBST(node.right, max, node.value);
    }
    public Node rightRotate(Node node){
        //before swap
        Node x=node;
        Node y=x.left;
        Node t2=y.right;
        //after swap
        y.right=x;
        x.left=t2;
        return y;
    }
    public Node leftROtate(Node node){
        //before swap
        Node x=node;
        Node y=x.right;
        Node t2=y.left;
        //after swap
        y.left=x;
        x.right=t2;
        return y;

    }
}
