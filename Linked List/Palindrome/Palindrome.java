
import java.util.Stack;

public class Palindrome {
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
        int[] arr = {1,2,4,5,3,5,4,2,1};
        Node head = new Node(0);
        Node newhead = head;
        for(int i = 0;i<arr.length;i++) {
            newhead.next = new Node(arr[i]);
            newhead = newhead.next;
        }
        head = head.next;
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(Node head){
        int count = 0;
        Node curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        Stack<Node> s = new Stack<>();
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            s.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(count%2 != 0){
            slow = slow.next;
        }

        fast = head;
        while(slow!=null){
            if(slow.data != s.pop().data){
                System.out.println("Comparing -> "+slow.data +" & "+ s.peek().data);
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}


