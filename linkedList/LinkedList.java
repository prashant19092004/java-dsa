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
    public static int size;

    public void addFirst(int data) {
        // step1 : Crate a Node
        Node newNode = new Node(data);
        size++;

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
        size++;

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

    public void addMiddle(int data, int idx){
        //step1 : if idx is 0 then addFirst
        if(idx == 0){
            addFirst(data);
            return;
        }

        Node temp = head;
        int i = 0;
        idx = idx - 1;

        //step2 : Traverse the list till idx
        while(i < idx){
            temp = temp.next;
            i++;
        }

        //step3 : Create a Node
        Node newNode = new Node(data);

        //step4 : newNode next = temp next
        newNode.next = temp.next;

        //step5 : temp next = newNode
        temp.next = newNode;        
    }

    public void removeFirst(){

        //step1 : if head is null then print List is Empty
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        //step2 : if head = tail then head = tail = null
        if(head == tail){
            head = tail = null;
            size = 0;
            return;
        }

        //step3 : head = head next
        head = head.next;
        size--;
    }

    public void removeLast(){

        //step1 : Create a temp Node and assign head to it
        Node temp = head;

        //step2 : if head is null then print List is Empty
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        //step3 : if head = tail then head = tail = null
        else if(head == tail){
            head = tail = null;
            size = 0;
            return;
        }

        //step4 : Traverse the list till second last Node
        while(temp.next != tail){
            temp = temp.next;
        }

        //step5 : tail = temp
        tail = temp;
        tail.next = null;
        size--;
    }

    public int reverseDisplay(Node head){
        if(head == tail){
            System.out.print(head.data + " ");
            return 1;
        }
        
        int fn = reverseDisplay(head.next);
        System.out.print(head.data + " ");
        return fn;
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

    public int itrSearch(int data){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(head.data == data){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int data){
        if(head == null){
            return -1;
        }

        if(head.data == data){
            return 0;
        }

        int idx = helper(head.next, data);

        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int recursionSearch(int data){
        return helper(head, data);
    }

    public void itrReverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n){

        if(head == null){
            System.out.print("List is Empty");
            return;
        }
        Node prev = head;
        Node curr = null;

        System.out.println((size-n));
        for(int i=0; i<((size-n)-1); i++){
            prev = prev.next;
        }

        curr = prev.next;
        prev.next = curr.next;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);

        return slow;
    }

    public boolean isPalindrome(){
        if(head == null ||head.next == null){
            return true;
        }

        Node midNode = findMid(head);

        Node curr = midNode;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while(right != null){
            if(right.data != left.data){
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean isCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    public Node findMid2(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node merge(Node left, Node right){
        Node dummy = new Node(-1);
        Node prev = dummy;

        Node c1 = left;
        Node c2 = right;

        while(c1 != null && c2 != null){
            if(c1.data < c2.data){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = findMid2(head);

        Node left = head;
        Node right = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(left);
        Node newRight = mergeSort(right);

        return merge(newLeft, newRight);
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        // System.out.print(ll.recursionSearch(30));

        // ll.deleteNthFromEnd(2);
        
        // ll.display();
        // ll.itrReverse();
        ll.display();
        ll.head = ll.mergeSort(head);
        ll.display();
        // ll.reverseDisplay(head);
    }
}
