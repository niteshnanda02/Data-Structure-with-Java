package com.company.Online;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class huffman_encoder {
    //we will be using the heap we built(priority queue) and inbuilt hashmap of java
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;
    public huffman_encoder(String feeder){
        //1. create a freq map of this feeder string
        HashMap<Character,Integer> freqmap=new HashMap<>();
        for (int i = 0; i <feeder.length() ; i++) {
            char cc=feeder.charAt(i);
            if (freqmap.containsKey(cc)){
                int ov=freqmap.get(cc);
                int nv=ov+1;
                freqmap.put(cc,nv);
            }else {
                freqmap.put(cc,1);
            }
        }
        //2. Create a minheap of Trees
        Heapgeneric<Node> minHeap=new Heapgeneric<>();
        Set<Map.Entry<Character,Integer>> entries=freqmap.entrySet();
        for (Map.Entry<Character,Integer> entry : entries) {
            Node node=new Node(entry.getKey(),entry.getValue());
            minHeap.add(node);
        }
         //3. Combine nodes until one node is left in heap
        while (minHeap.size()!=1){
            Node minone=minHeap.remove();
            Node mintwo=minHeap.remove();

            Node combine=new Node(minone,mintwo);
            combine.data='\0';
            combine.cost=minone.cost+mintwo.cost;
            minHeap.add(combine);
        }
        Node ft=minHeap.remove();
        this.encoder=new HashMap<>();
        this.decoder=new HashMap<>();
        this.initencoderdecoder(ft,"");
    }

    private void initencoderdecoder(Node node, String osf) {
        if (node==null){
            return;
        }
        if (node.left==null&&node.right==null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        this.initencoderdecoder(node.left,osf+"0");
        this.initencoderdecoder(node.right,osf+'1');
    }
    public String encode(String source){
        String rv="";
        for (int i = 0; i <source.length() ; i++) {
            String code=this.encoder.get(source.charAt(i));
            rv+=code;
        }
        return rv;
    }
    public String decode(String codedsource){
        String rv="";
        String key="";
        for (int i = 0; i <codedsource.length() ; i++) {
            key+=codedsource.charAt(i);
            if (this.decoder.containsKey(key)){
                rv+=this.decoder.get(key);
                key="";
            }
        }
        return rv;
    }

    private class Node implements Comparable<Node>{
        char data;
        int cost;
        Node left;
        Node right;

        Node(char data,int cost){
            this.data=data;
            this.cost=cost;
            this.left=null;
            this.right=null;
        }
        Node(Node left,Node right){
            this.left=left;
            this.right=right;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
}
