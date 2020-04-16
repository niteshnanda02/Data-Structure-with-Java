package com.company.Online;

public class Linkedlist<T> {
    private class Node {
        T data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {

        return head == null;
    }

    public void display() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "=>");
            temp = temp.next;
        }
    }

    public void addLast(T item) {
        //1.create a new node
        Node nn = new Node();
        nn.data = item;
        nn.next = null;
        //2.attach
        if (size >= 1) {
            this.tail.next = nn;
            this.tail = nn;
            this.size++;

        }
        //3.update summary object
        if (size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
//        }else {
//            this.tail=nn;
//       0     this.size++;
        }
    }

    public void addFirst(T item) {
        Node nn = new Node();
        nn.data = item;
        nn.next = null;
        if (size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        }
        if (size >= 1) {
            nn.next = this.head;
            this.head = nn;
            this.size++;
        }

    }

    public T getFirst() throws Exception {
        if (size == 0) {
            throw new Exception("LL is empty");
        }
        return this.head.data;
    }

    public T getLast() throws Exception {
        if (size == 0) {
            throw new Exception("LL is empty");
        }
        return this.tail.data;
    }

    public T getAt(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is empty");
        }
        if (index < 0 || index >= size) {
            throw new Exception("Invalid index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return temp.data;
    }

    private Node getNodeAt(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is empty");
        }
        if (index < 0 || index >= size) {
            throw new Exception("Invalid index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return temp;
    }

    public void insertNodeAt(T item, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Inavlid index");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == this.size) {
            addLast(item);
        } else {
            //1.Create a new node
            Node nn = new Node();
            nn.data = item;
            nn.next = null;
            //2.attach
            Node nm1 = getNodeAt(index - 1);
            Node np1 = nm1.next;
            nm1.next = nn;
            nn.next = np1;
            //3.Summary
            this.size++;
        }
    }

    public T RemoveFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is empty");
        }
        T temp = head.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            this.head = this.head.next;
            this.size--;
        }
        return temp;
    }

    public T RemoveLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is empty");
        }
        T temp = tail.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            Node sizem2 = getNodeAt(size - 2);
            this.tail = sizem2;
            this.tail.next = null;
            this.size--;
        }
        return temp;
    }

    public T RemoveAt(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is empty");
        }
        if (index < 0 || index >= this.size) {
            throw new Exception("Invalid index");
        }
        if (index == 0) {
            return RemoveFirst();
        } else if (index == this.size - 1) {
            return RemoveLast();
        } else {
            Node nm1 = getNodeAt(index - 1);
            Node n = getNodeAt(index);
            Node np1 = getNodeAt(index + 1);
            nm1.next = np1;
            this.size--;
            return n.data;
        }
    }

    public void ReverseData() throws Exception {
        int left = 0;
        int right = this.size - 1;
        while (left < right) {
            Node ld = getNodeAt(left);
            Node rd = getNodeAt(right);
            T temp = ld.data;
            ld.data = rd.data;
            rd.data = temp;
            left++;
            right--;
        }
    }

    public T mid() {
        Node slow = this.head;
        Node fast = this.head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int find(T data) {
        int index = 0;
        for (Node temp = this.head; temp != null; temp = temp.next) {
            if (temp.data.equals(data)) {
                return index;
            }
            index++;
        }
        return -1;
    }


}
