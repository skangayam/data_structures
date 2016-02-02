public class Node {
    int data;
    Node next;

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
}
