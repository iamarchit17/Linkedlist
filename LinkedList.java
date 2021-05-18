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

    public void push(LinkedList this, int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void append(LinkedList this, int data){
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node last_node = head;
            while (last_node.next != null) {
                last_node = last_node.next;
            }
            last_node.next = new_node;
        }
    }

    public void insertAfter(LinkedList this, Node prev_node, int data){
        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void printLinkedList(LinkedList this) {
        Node current_node = head;
        System.out.print("head -> ");
        while(current_node != null){
            System.out.print(current_node.data + " -> ");
            current_node = current_node.next;
        }
        System.out.println("null");
    }

    public void deleteKey(LinkedList this, int key){
        if(head == null){
            return;
        }
        if(head.data == key){
            Node temp = head;
            head = head.next;
            temp = null;
        } else {
            Node curr_node = head.next;
            Node prev_node = head;

            while(curr_node != null){
                if(curr_node.data == key){
                    prev_node.next = curr_node.next;
                    curr_node = null;
                    break;
                } else {
                    prev_node = curr_node;
                    curr_node = curr_node.next;
                }
            }
        }
    }

    public static void main(String []args){
        LinkedList list = new LinkedList();
        list.push(5);
        list.push(7);
        list.append(8);
        list.push(9);
        list.append(11);
        list.append(12);
        Node n = list.head.next;
        list.insertAfter(n, 8);
        list.printLinkedList();
        list.deleteKey(9);
        list.printLinkedList();
        list.deleteKey(8);
        list.printLinkedList();
        list.deleteKey(12);
        list.printLinkedList();
    }
}


