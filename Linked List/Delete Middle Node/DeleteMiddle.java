public class DeleteMiddle {
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node newhead = head;
        int[] arr = {1,2,3,4,5,6,7};
        for(int i: arr){
            newhead.next = new Node(i);
            newhead = newhead.next;
        }
        head = head.next;
        //The linked list is created
        Node temp = deleteMiddle(head);
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public static Node deleteMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.data = slow.next.data;
        slow.next = slow.next.next;
        return head;
    }
}
