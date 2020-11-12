package com.company.graph.Question;

import java.util.*;

public class DijikstraAlgorithm {
    static class Node{
        int node, cost;

        public Node(int node, int c) {
            this.node = node;
            this.cost = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", cost=" + cost +
                    '}';
        }
    }
    static ArrayList<ArrayList<Node>> adj;
    static Map<Integer,dijikstraPair> map=new HashMap<>();
    static Map<Integer,Integer> ans=new HashMap<>();
    public static void main(String[] args) {
        map.clear();
        ans.clear();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        adj=new ArrayList<>(n+1);
        for (int i = 0; i <n+1 ; i++) {
            adj.add(new ArrayList<>());
        }
        int m=s.nextInt();

        for (int i = 0; i <m ; i++) {
            int a=s.nextInt(),b=s.nextInt(),c=s.nextInt();
            adj.get(a).add(new Node(b,c));
            adj.get(b).add(new Node(a,c));
        }
        dijikstra(1,n);
        System.out.println(ans);
    }
    private static class dijikstraPair{
        int vname;
        String psf;
        int cost;

        public dijikstraPair(int vname, String psf, int cost) {
            this.vname = vname;
            this.psf = psf;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "dijikstraPair{" +
                    "vname=" + vname +
                    ", cost=" + cost +
                    '}';
        }
    }
    private static void dijikstra(int src, int n) {
        PriorityQueue<dijikstraPair> minHeap=new PriorityQueue<>(new Comparator<dijikstraPair>() {
            @Override
            public int compare(dijikstraPair dijikstraPair, dijikstraPair t1) {
                return dijikstraPair.cost-t1.cost;
            }
        });
        dijikstraPair pair=new dijikstraPair(src,src+"",0);
        map.put(src,pair);
        minHeap.add(pair);
        for (int i = 2; i <=n ; i++) {
            dijikstraPair dpair=new dijikstraPair(i,"",Integer.MAX_VALUE);
            map.put(i,dpair);
            minHeap.add(dpair);
        }

        while (!minHeap.isEmpty()){
            dijikstraPair rp=minHeap.remove();
            map.remove(rp.vname);
            ans.put(rp.vname,rp.cost);
            for (Node child:adj.get(rp.vname)
                 ) {
                if(map.containsKey(child.node)){
                    int oc=map.get(child.node).cost;
                    int nc=rp.cost+child.cost;
                    if(nc<oc){
                        dijikstraPair dpair=map.get(child.node);
                        minHeap.remove(dpair);
                        dpair.cost=nc;
                        dpair.psf=rp.psf+child.node;
                        minHeap.add(dpair);
                    }
                }
            }
        }
    }
}
