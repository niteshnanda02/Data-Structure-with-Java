

import com.company.Trie.Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class shortestUniquePrefix {
    public static class Trie {
        private class Node{
            char data;
            Map<Character, Node> children;
            boolean isTerminal;
            int frequency;

            public Node(char data, boolean isTerminal, int frequency) {
                this.data = data;
                this.isTerminal = isTerminal;
                this.frequency = frequency;
                children=new HashMap<>();
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        ", children=" + children +
                        ", isTerminal=" + isTerminal +
                        ", frequency=" + frequency +
                        '}'+"\n";
            }
        }
        private Node root;
        private int numOfWords;

        public Trie() {
            root=new Node('\0',false,0);
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
                child=new Node(cc,false,1);
                parent.children.put(cc,child);
            }else {
                child.frequency += 1;
            }
            add(child,ros);
        }

        public void display(){
            display(this.root,"");
        }

        private void display(Node node, String osf) {
            if (node==null)
                return;

            if(node.frequency==1){
                String toDisplay=osf.substring(1)+node.data;
                System.out.println(toDisplay);
                return;
            }

            Set<Map.Entry<Character, Node>> entries=node.children.entrySet();
            for (Map.Entry<Character, Node> entry:entries){
                display(entry.getValue(),osf+node.data);
            }


        }


    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        Trie trie=new Trie();
        for (int i = 0; i <arr.length ; i++) {
            trie.add(arr[i]);
        }
        trie.display();
    }
}
  
