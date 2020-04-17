package com.company.Online;

import java.util.ArrayList;
import java.util.Scanner;

public class geneic_tree {
    public class Node{
        int data;
        ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    public Node root;
    public int size;

    public geneic_tree() {
        Scanner s=new Scanner(System.in);
        this.root=this.takeinput(s,null,0);
    }
    public Node takeinput(Scanner s,Node parent,int ithchildren){
        if (parent==null){
            System.out.println("Enter the value for parent");
        }else {
            System.out.println("Eter the value of "+ithchildren+" of parent"+parent.data);
        }
        int nodeData=s.nextInt();
        Node node=new Node(nodeData);
        this.size++;
        System.out.println("Enter the number of children "+node.data);
        int children=s.nextInt();
        for (int i = 0; i <children ; i++) {
            Node child=this.takeinput(s,node,i);
            node.children.add(child);
        }
        return node;
    }
    public void display(){
        this.display(this.root);
    }

    private void display(Node node) {
        String str=node.data+"=>";
        for (int i = 0; i <node.children.size() ; i++) {
            str=str+node.children.get(i).data+",";
        }
        str=str+"END";
        System.out.println(str);
        for (int i = 0; i <node.children.size() ; i++) {
            this.display(node.children.get(i));
        }
    }
}
