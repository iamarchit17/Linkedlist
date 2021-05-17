package com.company;
class LinkedList{
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public void push(LinkedList list, int data){
        Node new_node = new Node(data);
        new_node.next = list.head;
        list.head = new_node;
    }

    public void append(LinkedList list, int data){
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last_node = list.head;
            while (last_node.next != null) {
                last_node = last_node.next;
            }
            last_node.next = new_node;
        }
    }

    public void insertAfter(LinkedList list, Node prev_node, int data){
        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void printLinkedList(LinkedList list) {
        Node current_node = list.head;
        System.out.print("head -> ");
        while(current_node != null){
            System.out.print(current_node.data + " -> ");
            current_node = current_node.next;
        }
        System.out.println("null");
    }

    public static void main(String []args){
        LinkedList list = new LinkedList();
        list.push(list, 5);
        list.push(list, 7);
        list.append(list, 8);
        list.push(list, 9);
        list.append(list, 11);
        Node n = list.head.next;
        list.insertAfter(list, n, 12);
        list.printLinkedList(list);

    }
}


