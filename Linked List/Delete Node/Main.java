import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            ll.add(x);
        }
        int toRemove = input.nextInt();
		// System.out.print(toRemove + "*" + ll.head.data);
        Solution s = new Solution();
        s.remove(ll, toRemove);
        Node curr = ll.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

 
class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}
 
class Solution {
	public static int getLength(Node head){
		int len = 0;
		Node curr = head;
		while(curr != null){
			len++;
			curr = curr.next;
		}
		return len;
	}
	public static void removeLast(Node head){
		Node curr = head;
		while(curr.next.next != null){
			curr = curr.next;
		}
		curr.next = null;
	}

	public static Node getNodeAt(Node head, int idx){
		Node curr = head;
		for(int i=0;i<idx;i++){
			if(curr == null){
				return null;
			}
			curr = curr.next;
		}
		return curr;
	}
	
    public static void remove(LinkedList ll, int toRemove){
        Node head = ll.head;
		int size = getLength(ll.head);
		// System.out.print(size);
		if(size == 0){
			return ;
		}
		if(size == 1 && toRemove == 0){
			// System.out.print("#");
			ll.head = null;
			return ;
		}

		if(toRemove == 0 ){
			ll.head = ll.head.next;
			
		}
		else if(toRemove == size-1){
			removeLast(ll.head);
		}
		else{
			Node curr = getNodeAt(ll.head, toRemove-1);
			if(curr == null ){
				return ;
			}
			curr.next = curr.next.next;
		}
		
		
    }
}