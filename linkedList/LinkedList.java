public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        // step1 : Crate a Node
        Node newNode = new Node(data);

        // step2 : if head is null then head = tail = newNode
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step3 : newNode next = head
        newNode.next = head;

        // step4 : head = newNode
        head = newNode;
    }

    public void addLast(int data){
        //step1 : Create a Node
        Node newNode = new Node(data);

        //step2 : if head is null then head = tail = newNode
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step3 : tail next = newNode
        tail.next = newNode;

        //step4 : tail = newNode
        tail = newNode;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.addLast(40);
    }
}
