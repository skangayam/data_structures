public class Start {

    public static void main(String[] args) {
        Node headA = new Node();
        headA.data = 1;
        headA.next = null;
        headA = Node.addNode(headA, 3);
//        headA = Node.addNode(headA, 5);
//        headA = Node.addNode(headA, 7);

        Node.printLinkedList(headA);

        Node headB = new Node();
        headB.data = 1;
        headB.next = null;
        headB = Node.addNode(headB, 2);
//        headB = Node.addNode(headB, 5);
//        headB = Node.addNode(headB, 7);

        Node.printLinkedList(headB);



        Node result = Node.mergeLists(headA, headB);
        Node.printLinkedList(result);





    }
}