import com.skangayam.algorithms.singleLinkedList.Node;

public class Start {

    public static void main(String[] args) {

        Node head = new Node();
        head.data = 1;
        head.next = null;
        head  = Node.addNode(head, 2);
        head = Node.addNode(head, 3, 0);
        Node.printLinkedList(head);

    }
}