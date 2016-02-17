package com.skangayam.algorithms.singleLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Node {
    public int data;
    public Node next;

    public static Node reverse(Node head){


        Node prev = null;
        Node next = null;

        if (head != null){
            while (head != null){
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
                if (head == null){
                    return prev;
                }
            }
        }
        return null;
    }

    public static Node addNode(Node head, int data) {
        if (head != null){
            Node currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;
            currentNode.next = newNode;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        if (head != null){
            Node currentNode = head;
            while (currentNode != null){
                System.out.print(currentNode.data+ " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }

    public static Node removeDuplicates(Node head){
        if(head != null){
            Node previousNode = null;
            Node currentNode = head;
            int count = 0;
            while(currentNode != null){
                if(currentNode != head){
                    if(currentNode.data == previousNode.data){
                        count += 1;
                        currentNode = currentNode.next;
                        if(currentNode == null){
                            previousNode.next = currentNode;
                        }
                    }else{
                        if(count == 0){
                            previousNode = currentNode;
                            currentNode = currentNode.next;
                        }else{
                            previousNode.next = currentNode;
                            previousNode = currentNode;
                            currentNode = currentNode.next;
                            count = 0;
                        }
                    }
                }else{
                    previousNode = head;
                    currentNode = head.next;
                }
            }
        }
        return head;
    }

    public static Node mergeLists(Node headA, Node headB) {
        if (headA == null && headB != null){
            return headB;
        }else if (headA != null && headB == null){
            return headA;
        }else if(headA == null && headB == null){
            return null;
        }

        Node currentA = headA;
        Node currentB = headB;
        Node result;

        if (headA.data < headB.data){
            result = headA;
            currentA = headA.next;
        }else {
            result = headB;
            currentB = headB.next;
        }

        Node resultHead = result;

        while (currentA != null && currentB != null){
            if (currentA.data < currentB.data){
                result.next = currentA;
                currentA = currentA.next;
                result = result.next;
            }else {
                result.next = currentB;
                currentB = currentB.next;
                result = result.next;
            }
        }

        if (currentA == null && currentB != null){
            result.next = currentB;
        }else if (currentA != null && currentB == null){
            result.next = currentA;
        }

        return resultHead;
    }

    public static int getNode(Node head,int n) {


        List<Integer> arr = new ArrayList<Integer>();
        while (head != null){
            arr.add(head.data);
            head = head.next;
        }

        int size = arr.size();
        return arr.get(size - 1 - n);

    }

    public static int compareLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method

        if ((headA != null && headB == null) || (headA == null && headB != null)){
            return 0;
        }

        while (headA != null && headB != null){
            if (headA.data != headB.data){
                return 0;
            }
            headA = headA.next;
            headB = headB.next;
        }

        if ((headA != null && headB == null) || (headA == null && headB != null)){
            return 0;
        }

        return 1;
    }

    public static void reversePrint(Node head){
        if (head == null){
            return;
        }

        List<Integer> arr = new ArrayList<Integer>();
        while (head != null){
            arr.add(head.data);
            head = head.next;
        }

        for (int i = arr.size(); i > 0 ; i--) {
            System.out.println(arr.get(i-1));
        }

    }

    public static int findMergeNode(Node headA, Node headB){

        HashSet<Node> hashSet = new HashSet<Node>();
        while (headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }


        while (headB != null){
            if (hashSet.contains(headB)){
                return headB.data;
            }
            headB = headB.next;
        }

        return 0; // No merge
    }

    public static int hasCycle(Node head) {

        // return 1 if there is a cycle
        // return 0 if not
        HashMap<Node, String> hm = new HashMap<Node, String>();

        if (head != null){
            while (head != null){
                if (hm.containsKey(head)){
                    return 1;
                }
                hm.put(head,"");
                head = head.next;
            }
        }

        return  0;

    }

    public static Node deleteNode(Node head, int position){

        Node result = head;
        int ptr = 0;

        if (head != null){
            if (position == 0){
                result = head.next;
                return result;
            }

            while (head != null){
                if (ptr + 1 == position){
                    head.next = head.next.next;
                    return result;
                }
                head = head.next;
                ptr += 1;
            }
        }

        return  result;
    }


    public static Node addNode(Node head, int data, int position){

        Node result = new Node();
        result.data = data;
        result.next = null;

        if (head != null){
            if (position == 0){
                result.next = head;
                return result;
            }else {
                Node temp = head;
                int i = 0;
                while (head != null){
                    if (i + 1 == position){
                        result.next = head.next;
                        head.next = result;
                        return temp;
                    }
                    i += 1;
                    head = head.next;
                }
                result = temp;
            }
        }

        return null;


    }
}
