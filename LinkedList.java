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

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public void insertAfter(Node prevNode, int data){
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void printLinkedList() {
        Node currentNode = head;
        System.out.print("head -> ");
        while(currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public void deleteKey(int key){
        if(head == null){
            return;
        }
        if(head.data == key){
            Node temp = head;
            head = head.next;
            temp = null;
        } else {
            Node currNode = head.next;
            Node prevNode = head;

            while(currNode != null){
                if(currNode.data == key){
                    prevNode.next = currNode.next;
                    currNode = null;
                    break;
                } else {
                    prevNode = currNode;
                    currNode = currNode.next;
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


