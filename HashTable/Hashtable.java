package com.company.Online;

public class Hashtable<K, V> {
    private class HTPair {
        K key;
        V value;

        public HTPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            HTPair op = (HTPair) obj;
            return this.key.equals(op.key);
        }

        @Override
        public String toString() {
            return "{" + this.key + "-" + this.value + "}";

        }

    }

    public static final int DEFAULT_CAPACITY = 10;
    private Linkedlist<HTPair>[] bucketarray;
    private int size;

    public Hashtable() {
        this(DEFAULT_CAPACITY);
    }

    public Hashtable(int capacity) {
        this.bucketarray = (Linkedlist<HTPair>[]) new Linkedlist[capacity];
        this.size = 0;
    }

    public void put(K key, V value) throws Exception {
        int bi = hashfunction(key);
        Linkedlist<HTPair> bucket = this.bucketarray[bi];
        HTPair pta = new HTPair(key, value);
        if (bucket == null) {
            bucket = new Linkedlist<>();
            bucket.addLast(pta);
            this.bucketarray[bi] = bucket;
            this.size++;
        } else {
            int findAt = bucket.find(pta);
            if (findAt == -1) {
                bucket.addLast(pta);
                this.size++;
            } else {
                HTPair pair = bucket.getAt(findAt);
                pair.value = value;
            }
            double lambda=(size*1.0)/this.bucketarray.length;
            if (lambda>0.75){
                this.rehash();
            }

        }

    }

    private void rehash() throws Exception{
        Linkedlist<HTPair>[] oba=this.bucketarray;
        this.bucketarray=(Linkedlist<HTPair>[]) new Linkedlist[2*oba.length];
        this.size = 0;
        for (Linkedlist<HTPair> ob:oba){
            while (ob!=null&&!ob.isEmpty()){
                HTPair pair=ob.RemoveFirst();
                this.put(pair.key,pair.value);
            }
        }
    }

    public V get(K key)throws Exception{
        int bi = hashfunction(key);
        Linkedlist<HTPair> bucket = this.bucketarray[bi];
        HTPair ptf = new HTPair(key, null);
        if (bucket==null){
            return null;
        }else {
            int findAt = bucket.find(ptf);
            if (findAt == -1) {
               return null;
            } else {
                HTPair pair=bucket.getAt(findAt);
                return pair.value;
            }

        }

    }
    public V remove(K key)throws Exception{
        int bi = hashfunction(key);
        Linkedlist<HTPair> bucket = this.bucketarray[bi];
        HTPair ptf = new HTPair(key, null);
        if (bucket==null){
            return null;
        }else {
            int findAt = bucket.find(ptf);
            if (findAt == -1) {
                return null;
            } else {
                HTPair pair=bucket.getAt(findAt);
                bucket.RemoveAt(findAt);
                this.size--;
                return pair.value;
            }

        }

    }

    public void display()throws Exception {
        for (Linkedlist<HTPair> bucket : bucketarray) {
            if (bucket != null && !bucket.isEmpty()) {
                bucket.display();
            } else {
                System.out.println("NULL");
            }
        }
    }

    private int hashfunction(K key) {
        int hc = key.hashCode();
        hc = Math.abs(hc);
        int bi = hc % bucketarray.length;
        return bi;
    }
}
