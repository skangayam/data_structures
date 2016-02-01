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
}
