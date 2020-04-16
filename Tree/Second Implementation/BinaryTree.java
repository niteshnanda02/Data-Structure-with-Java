package com.company.Online;

import java.util.*;

public class BinaryTree {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public Node root = null;
    private int size;

    public BinaryTree() {
        Scanner s = new Scanner(System.in);
        this.root = takeinput(s, null, false);
    }

    private Node takeinput(Scanner s, Node parent, boolean isLeftorRight) {
        if (parent == null) {
            System.out.println("enter the data for root node");
        } else {
            if (isLeftorRight) {
                System.out.println("enter the data for left child" + parent.data);
            } else {
                System.out.println("enter the data for right child" + parent.data);
            }

        }
        int nodedata = s.nextInt();
        Node node = new Node(nodedata, null, null);
        this.size++;
        boolean choice = false;
        System.out.println("Do you have left child of node" + node.data);
        choice = s.nextBoolean();
        if (choice) {
            node.left = takeinput(s, node, true);
        }
        System.out.println("Do you have right child of node" + node.data);
        choice = s.nextBoolean();
        if (choice) {
            node.right = takeinput(s, node, false);
        }
        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + node.left.data + "=>";
        } else {
            str = str + "End=>";
        }
        str = str + node.data;
        if (node.right != null) {
            str = str + "<=" + node.right.data;
        } else {
            str = str + "<=End";
        }
        System.out.println(str);
        if (node.left != null) {
            this.display(node.left);
        }
        if (node.right != null) {
            this.display(node.right);
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lheight = height(node.left);
        int rheight = height(node.right);
        int height = Math.max(lheight, rheight) + 1;
        return height;
    }

    public void preorder() {
        this.preorder(this.root);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {
        this.postorder(this.root);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + ", ");
    }

    public void inorder() {
        this.inorder(this.root);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + ", ");
        inorder(node.right);

    }

    public void levelOrder() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node rv = queue.removeFirst();
            System.out.println(rv.data + ", ");
            if (rv.left != null) {
                queue.addLast(rv.left);
            }
            if (rv.right != null) {
                queue.addLast(rv.right);
            }
        }
    }

    public void verticalOrder() {
        HashMap<Integer,String> map=new HashMap<>();

        print(this.root,0,map);
        System.out.println(map);
    }

    private void print(Node node, int hd, HashMap<Integer, String> map) {
        if (map.containsKey(hd)){
            String ov=map.get(hd);
            map.put(hd,ov+" "+String.valueOf(node.data));
        }else {
            map.put(hd,String.valueOf(node.data));
        }
        if (node.left!=null){
            print(node.left,hd-1,map);
        }
        if (node.right!=null){
            print(node.right,hd+1,map);
        }
    }
    public void topOrder(){
        HashMap<Integer,String> map=new HashMap<>();
        print(this.root,0,map);
        Set<Integer> set=map.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);

        for (int j = 0; j <arr.length ; j++) {
            System.out.print(map.get(arr[j]).charAt(0));
        }
    }

    public boolean isBST() {
        return this.isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data > max || node.data < min) {
            return false;
        } else if (!isBST(node.left, min, node.data)) {
            return false;
        } else if (!isBST(node.right, node.data, max)) {
            return false;
        }
        return true;
    }
}
