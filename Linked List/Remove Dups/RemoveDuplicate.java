
public class RemoveDuplicate {
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            this.data = d;
            next = null;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,2,3,1,6,7,5,2};
        Node head = new Node(0);
        Node newhead = head;
        for(int i = 0;i<arr.length;i++) {
            newhead.next = new Node(arr[i]);
            newhead = newhead.next;
        }
        head = head.next;

        Node head1 = remove(head);
        Node curr = head1;
        while(curr.next!=null){
            System.out.print(curr.data+" -> ");
            curr = curr.next;
        }
        System.out.print(curr.data);

    }
    public static Node remove(Node head){
        Node curr = head;
        while(curr!=null){
            Node temp = curr;

            while(temp.next!=null){
                if(temp.next.data == curr.data){
                    temp.next = temp.next.next;
                }
                else{
                    temp = temp.next;
                }



            }
            curr = curr.next;
        }
        return head;
    }
}

