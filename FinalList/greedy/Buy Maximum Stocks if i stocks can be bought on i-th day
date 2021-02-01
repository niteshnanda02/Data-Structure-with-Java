package com.company.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumStockOnIthDay {
    static class Pair{
        int cost,day;

        public Pair(int cost, int day) {
            this.cost = cost;
            this.day = day;
        }
    }
    public static void main(String[] args) {
        int[] price={10,7,19};
        int k=45;
        System.out.println(maxStock(price,k));
    }

    private static int maxStock(int[] price, int k) {
        int n=price.length;
        Pair[] pairs=new Pair[n];
        for (int i = 0; i <n ; i++) {
            pairs[i]=new Pair(price[i],i+1);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                if (pair.cost==t1.cost)
                    return pair.day-t1.cost;
                return pair.cost-t1.cost;
            }
        });
        int stock=0;
        for (int i = 0; i <n ; i++) {
            int days=Math.min(pairs[i].day,k/pairs[i].cost);
            stock+=days;
            k-=pairs[i].cost*days;
        }
        return stock;

    }
}
