package com.company.offline;

import java.util.*;

public class Tree {
    private class Node {
        private int value;
        private ArrayList<Node> children;
        private Node parent;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public Node root;

    public void populate() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter value for root node");
        int value = s.nextInt();
        this.root = new Node(value);
        populate(root, s);
    }

    private void populate(Node node, Scanner s) {
        System.out.println("how many children for " + node.value);
        int count = s.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.printf("enter %d the child node of %d:", i, node.value);
            int value = s.nextInt();
            Node child = new Node(value);
            node.children.add(child);
            child.parent = node;
            populate(child, s);

        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        System.out.println(indent + node.value);
        for (int i = 0; i < node.children.size(); i++) {
            display(node.children.get(i), indent + "\t");
        }
    }

    private void preorder(Node node) {
        System.out.print(node.value + " ");
        for (int i = 0; i < node.children.size(); i++) {
            preorder(node.children.get(i));
        }
    }

    private void postorder(Node node) {
        for (int i = 0; i < node.children.size(); i++) {
            postorder(node.children.get(i));
        }
        System.out.println(node.value + " ");
    }
    public void levelorder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.value);
            for (int i = 0; i < node.children.size(); i++) {
                queue.add(node.children.get(i));
            }
        }

    }
    public void preorder() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
    }


}
