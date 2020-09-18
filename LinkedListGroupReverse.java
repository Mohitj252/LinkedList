package main.java.linkedlist;

import java.util.Stack;

/**
 * Reverse a group of nodes in linked list.
 * @author mohitjai
 *
 */
public class LinkedListGroupReverse {
	
	static class Node2{
		int data;
		Node2 next;
		Node2(int data){
			this.data =data;
			this.next = null;
		}
		
	}
	
	private Node2 reverseUsingRecursion(Node2 head, int splitCount){
		/*head points to the first node of the slot for eg if splitCount is 2 and the values are 1, 2, 3, 4. 
		so for first reverse call head points to 1 and for the next recursive call head points to 3.*/
		
		Node2 current = head;
		Node2 prev = null; Node2 next = null;
		int count =0;
		
		while(count < splitCount && current != null ){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count ++;
		}
		
		if(next!= null)
		head.next = reverseUsingRecursion(next, splitCount);
		
		return prev;
		
	}
	
	private Node2 reverseUsingStack (Node2 head, int splitCount){
		Stack<Node2> stack = new Stack();
		Node2 current = head;
		Node2 prev = null;
		while(current !=null){
			int count = 0;
			while(count < splitCount & current != null){
				stack.push(current);
				current = current.next;
				count ++;
			}
			
			while(!stack.isEmpty()){
				
				if(prev ==null){
					prev = stack.pop();
					head = prev;
				
				}
				else{
					prev.next = stack.pop();
					prev = prev.next;
				
				}
				
			}
		}
		prev.next = null;
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node2 node = new Node2(1);
		Node2 head = node;
		node.next = new Node2(2);
		node.next.next = new Node2(3);
		node.next.next.next = new Node2(4);
		node.next.next.next.next = new Node2(5);
		
		
		while(node != null){
			System.out.print(node.data);
			node = node.next;
			if(node!= null){
				System.out.print(",");
			}
		}
		System.out.println("");
		LinkedListGroupReverse llgr = new LinkedListGroupReverse();
		Node2 reverseList = llgr.reverseUsingStack(head, 2);
		while(reverseList != null){
			System.out.print(reverseList.data);
			reverseList = reverseList.next;
			if(reverseList!= null){
				System.out.print(",");
			}
		}
		

	}

}


