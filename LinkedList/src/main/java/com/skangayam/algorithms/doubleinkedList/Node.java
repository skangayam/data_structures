package com.skangayam.algorithms.doubleinkedList;


public class Node {

    public int data;
    public Node next;
    public Node prev;

    public static void printLinkedList(Node head){
        if (head != null){

            while (head != null){
                System.out.print(head.data+ " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static Node reverse(Node head) {
        if (head != null){
            Node result = head;
            while (head != null){
                Node next = head.next;
                Node prev = head.prev;
                head.prev = next;
                head.next = prev;
                if (next == null){
                    return head;
                }
                head = next;
            }
        }
        return null;
    }

    public static Node sortedInsert(Node head,int data) {

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;

        Node result = head;

        if(head != null){

            while (head != null){
                if (newNode.data <= head.data){
                    if (head.prev == null){
                        newNode.next = head;
                        head.prev = newNode;
                        return newNode;
                    }else if (head.next != null || head.next == null){
                        newNode.prev = head.prev;
                        newNode.next = head;
                        head.prev.next = newNode;
                        head.prev = newNode;
                        return result;
                    }
                }else if(newNode.data > head.data && head.next == null) {
                    newNode.prev = head;
                    head.next = newNode;
                    return result;
                }else {
                    head = head.next;
                }
            }

        }

        return result;

    }


}
