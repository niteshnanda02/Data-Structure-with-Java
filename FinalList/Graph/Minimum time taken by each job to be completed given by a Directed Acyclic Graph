package com.company.graph.Question;

import java.util.*;

public class MinimumTimeTakenForEachNode {
    static int[] in,res,job;
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        in=new int[n+1];
        res=new int[n+1];
        job=new int[n+1];
        adj=new ArrayList<>(n+1);
        for (int i = 0; i <n+1 ; i++) {
            adj.add(new ArrayList<>());
        }
        int m=s.nextInt();
        for (int i = 0; i <m ; i++) {
            int a=s.nextInt(),b=s.nextInt();
            adj.get(a).add(b);
            in[b]++;
        }
        //topological sort
        Queue<Integer> queue=new LinkedList<>();

        for (int i = 0; i <=n ; i++) {
            if(in[i]==0) {
                queue.add(i);
                job[i]=1;
            }
        }
        int index=0;
        while (!queue.isEmpty()){
            int rv=queue.poll();
            res[index]=rv;
            index++;
            for (int child:adj.get(rv)
                 ) {
                in[child]--;
                if(in[child]==0){
                    job[child]=1+job[rv];
                    queue.add(child);
                }
            }
        }
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(job));

    }
}
