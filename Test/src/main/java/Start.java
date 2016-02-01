public class Start {

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        head.next = null;
        head = Node.addNode(head, 1);
        head = Node.addNode(head, 3);
        head = Node.addNode(head, 3);
        Node.printLinkedList(head);
        Node.removeDuplicates(head);
        Node.printLinkedList(head);
    }
}