package com.company;

public class SegmentTree {
    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

    }

    Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int si, int ei) {
        if (si == ei) {
            Node leavenode = new Node();
            leavenode.data = arr[si];
            leavenode.startInterval = si;
            leavenode.endInterval = ei;
            leavenode.left = null;
            leavenode.right = null;
            return leavenode;
        }
        Node node = new Node();
        node.startInterval = si;
        node.endInterval = ei;
        int mid = (si + ei) / 2;
        node.left = constructTree(arr, si, mid);
        node.right = constructTree(arr, mid + 1, ei);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval + "] and data =" + node.left.data + " =>";
        } else {
            str = str + "no element in left side";
        }
        str = str + "Interval = [" + node.startInterval + "-" + node.endInterval + "] and data = " + node.data;
        if (node.right != null) {
            str = str + "<= data = " + node.right.data + " and Interval = [" + node.right.startInterval + "-" + node.right.endInterval + "]";
        } else {
            str = str + "no element in right side";
        }
        System.out.println(str);
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(int si, int ei) {
        return this.query(root, si, ei);
    }

    private int query(Node node, int qsi, int qei) {
        //overlapping
        //node is lying completelty lies inside the query jece it return its value
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }
        //not overlapp
        //lies outside the query
        else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        }
        //partial overlapping
        //overflow
        else {
            int leftans = query(node.left, qsi, qei);
            int rightans = query(node.right, qsi, qei);
            return leftans + rightans;

         }
    }

    public void update(int index, int newValue) {
        this.root.data = update(this.root, index, newValue);
    }

    private int update(Node node, int index, int newValue) {
        if (index == node.startInterval && index == node.endInterval) {
            node.data = newValue;
        } else {
            int leftvalue = update(node.left, index, newValue);
            int rightvalue = update(node.right, index, newValue);
            node.data = leftvalue + rightvalue;
        }

        return node.data;
    }
}