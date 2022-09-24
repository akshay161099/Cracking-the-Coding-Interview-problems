public class SumLists{
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,4,2,3,1,6};
        int[] arr2 = {3,6,1,4,8};
        Node head1 = new Node(0);
        Node head2 = new Node(0);
        Node newhead = head1;
        for(int i = 0;i<arr1.length;i++) {
            newhead.next = new Node(arr1[i]);
            newhead = newhead.next;
        }
        nwehead= head2;
        for(int i = 0;i<arr2.length;i++) {
            newhead.next = new Node(arr2[i]);
            newhead = newhead.next;
        }
        head1 = head1.next;
        head2 = head2.next;
        Node result = sumList(head1,head2);
        while(result!=null){
            System.out.print(result.data+"->");
            result = result.next;
        }

    }
    public static sumList(Node head1, Node head2){
        Node first = head1;
        Node second = head2;
        int sum = 0;
        int carry = 0;
        Node newList = new Node(0);
        Node newHead = newList;
        while(first!=null && second!=null){
            if(first.data+second.data+carry > 9){
                sum = (first.data+second.data+carry)%10;
                carry = 1;
            }
            else{
                sum = first.data+second.data;
                carry = 0;
            }
            newHead.next= new Node(sum);
            newHead = newHead.next;
            first = first.next;
            second = second.next;
        }
        while(first!=null){
            if(first.data+carry > 9){
                sum = (first.data+carry)%10;
                carry = 1;
            }
            else{
                sum = first.data+carry;
                carry = 0;
            }
            newHead = new Node(sum);
            newHead = newHead.next;
            first = first.next;
        }
        while(second!=null){
            if(second.data+carry > 9){
                sum = (second.data+carry)%10;
                carry = 1;
            }
            else{
                sum = second.data+carry;
                carry = 0;
            }
            newHead = new Node(sum);
            newHead = newHead.next;
            second = second.next;
        }
        if(carry == 1){
            newHead.next = new Node(1);
        }
        return newList.next;
    }
}