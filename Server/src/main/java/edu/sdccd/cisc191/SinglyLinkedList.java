package edu.sdccd.cisc191;


public class SinglyLinkedList<T> {

    public Node head;

    public class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size(Node head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + size(head.next);
        }
    }

    public int size() {
        return size(head);
    }

    private Node getTail(Node head) {
        if (head.next == null) {
            return head;
        }
        return getTail(head.next);
    }

    public boolean add(T data) {
        try {
            if (head == null) {
                head = new Node(data, null);
            } else {
                Node tail = getTail(head);
                tail.next = new Node(data, null);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}