package com.company.Trie;
import java.util.*;
public class Trie {
    private class Node{
        char data;
        Map<Character,Node> children;
        boolean isTerminal;

        public Node(char data, boolean isTerminal) {
            this.data = data;
            children=new HashMap<>();
            this.isTerminal = isTerminal;
        }
    }
    private Node root;
    private int numOfWords;

    public Trie() {
        root=new Node('\0',false);
        numOfWords =0;
    }
    public int getNumOfWords(){
        return numOfWords;
    }

    public void add(String word){
        add(this.root,word);
    }
    //O(word length)
    private void add(Node parent, String word) {

        if(word.length()==0){
            if (parent.isTerminal){
                //Word is already present there
            }else{
                parent.isTerminal=true;
            }
            return;
        }
        char cc=word.charAt(0);
        String ros=word.substring(1);
        Node child=parent.children.get(cc); //O(1)
        if(child==null){
            child=new Node(cc,false);
            parent.children.put(cc,child);
        }

        add(child,ros);
    }

    public void display(){
        display(this.root,"");
    }

    private void display(Node node, String osf) {

        if(node.isTerminal){
            String toDisplay=osf.substring(1)+node.data;
            System.out.println(toDisplay);
            return;
        }

        Set<Map.Entry<Character,Node>> entries=node.children.entrySet();
        for (Map.Entry<Character,Node> entry:entries){
            display(entry.getValue(),osf+node.data);
        }


    }
    //O(word length)
    public boolean search(String word){
        return search(this.root,word);
    }

    private boolean search(Node parent, String word) {
        if(word.length()==0){
            if (parent.isTerminal){
                return true;
            }else{
                return false;
            }
        }

        char cc=word.charAt(0);
        String ros=word.substring(1);
        Node child=parent.children.get(cc);
        if(child==null)
            return false;
        return search(child,ros);
    }
    //O(word length)
    public void remove(String word){
        remove(this.root,word);
    }

    private void remove(Node parent, String word) {

        if(word.length()==0){
            if(parent.isTerminal){
                parent.isTerminal=false;
            }
            return;
        }
        char cc=word.charAt(0);
        String ros=word.substring(1);
        Node child=parent.children.get(cc);

        if(child==null)
            return;
        remove(child,ros);

        if(!child.isTerminal&&child.children.size()==0){
            parent.children.remove(cc);
        }
    }

}
