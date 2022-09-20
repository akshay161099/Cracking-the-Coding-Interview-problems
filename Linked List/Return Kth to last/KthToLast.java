public class KthToLast{
    static class Node{
        int data;
        Node next;
        Node(int d){
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
        int k = 6;
        Node ans = kthLast(head,k);
        System.out.println(ans.data);

    }
    public static Node kthLast(Node head, int k){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        int x = 0;
        while(temp!=null && x != count-k){
            x++;
            temp = temp.next;
        }

        return temp;
    }
}
//  1->2->3->4->5->6->7
