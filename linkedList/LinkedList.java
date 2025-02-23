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

    public void display(){
        //step1 : Create a temp Node and assign head to it
        Node temp = head;

        //step2 : if there is no data then print List is Empty
        if(head == null){
            System.out.print("List is Empty");
            return;
        }

        //step3 : Traverse the list and print the data
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(20);
        // ll.addFirst(10);
        // ll.addLast(30);
        // ll.addLast(40);

        ll.display();
    }
}
