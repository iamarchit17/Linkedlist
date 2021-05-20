package com.company;
class LinkedList<T>{
    Node head;
    static class Node<T>{
        T data;
        Node next;
        Node(T d){
            data = d;
            next = null;
        }
    }

    public void push(T data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(T data){
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

    public void insertAfter(Node prevNode, T data){
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

    public void deleteKey(T key){
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
                if(currNode.data.equals(key)){
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
        LinkedList <String> list = new LinkedList<String>();
        list.push("Archit");
        list.push("is");
        list.append("Agrawal");
        list.push("My");
        list.append("and");
        list.append("I live in India");
        Node n = list.head;
        list.insertAfter(n, "name");
        list.printLinkedList();
        list.deleteKey("My");
        list.printLinkedList();
        list.deleteKey("Agrawal");
        list.printLinkedList();
        list.deleteKey("I live in India");
        list.printLinkedList();
    }
}