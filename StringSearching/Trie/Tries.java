
package com.company.Online;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {
    private class Node {
        char data;
        HashMap<Character, Node> children;
        boolean isTerminal;

        public Node(char data, boolean isTerminal) {
            this.data = data;
            this.children = new HashMap<>();
            this.isTerminal = isTerminal;
        }
    }

    private int numwords;
    private Node root;

    public Tries() {
        this.root = new Node('\0', false);
        this.numwords = 0;
    }

    public int numwords() {
        return this.numwords;
    }

    public void addWord(String word) {
        addWord(this.root, word);
    }

    private void addWord(Node parent, String word) {
        if (word.length() == 0) {
            if (parent.isTerminal) {
                //word is already exist
            } else {
                parent.isTerminal = true;
                this.numwords++;
            }
            return;
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if (child == null) {
            child = new Node(cc, false);
            parent.children.put(cc, child);
        }
        this.addWord(child, ros);
    }

    public void display() {
        this.display(this.root, "");
    }

    private void display(Node node, String osf) {
        if (node.isTerminal) {
            String todisplay = osf.substring(1) + node.data;
            System.out.println(todisplay);
        }
        Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
        for (Map.Entry<Character, Node> entry : entries) {
            this.display(entry.getValue(), osf + node.data);
        }
    }

    public boolean search(String word) {
        return this.search(this.root, word);
    }

    private boolean search(Node parent, String word) {
        if (word.length() == 0) {
            if (parent.isTerminal) {
                return true;
            } else {
                return false;
            }
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if (child == null) {
            return false;
        }
        return this.search(child, ros);
    }

    public void remove(String word) {
        this.remove(this.root, word);
    }

    private void remove(Node parent, String word) {
        if (word.length() == 0) {
            if (parent.isTerminal){
                parent.isTerminal=false;
                numwords--;
            }else {
                //Word is a part of some word
            }
            return;
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if (child == null) {
            return;
        }
        this.remove(child, ros);

        if (!child.isTerminal&&child.children.size()==0){
            parent.children.remove(cc);
        }
    }
}
