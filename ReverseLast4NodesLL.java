package main.java.linkedlist;

/**
 * Reverse Last 4 Nodes using Linked List.
 * @author mohitjai
 *
 */
public class ReverseLast4NodesLL {
	static Node head;
	Node newNode;
	Object value;

	static class Node<K> {
		K data;
		Node next;

		Node(K i) {
			this.data = i;
			this.next = null;
		}
	}

	private void push(Object i) {
		if (head == null) {
			head = new Node(i);
			return;
		}
		newNode = head;
		while(newNode.next != null){
			newNode = newNode.next;
		}
		newNode.next = new Node(i);
	}
	
	private Node reverseLast4Node(Node n, int reverseCount){
		if(n==null){
			return null;
		}
		int length =0;
		Node current = n;
		while(current != null){
			current = current.next;
			++length;
		}
		if(length < reverseCount){
		System.out.println("linked list length should be greater than the reverseCount length");
		return n;
		}
		Node temp =null;
		current = n;
		Node prev =null;
		Node next;
		for(int i=0; i<length - reverseCount; i++){
			if(i == length-reverseCount-1){
				temp = current;
			}
			current = current.next;	
		}
		while(current !=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		temp.next = prev;
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReverseLast4NodesLL rr = new ReverseLast4NodesLL();
		rr.push(1);
		rr.push(2);
		rr.push(3);
		rr.push(4);
		rr.push(5);
		rr.push(6);
		rr.push(7);
		rr.push(8);
		rr.push(9);
		Node output = rr.reverseLast4Node(head, 3);
		
		while(output !=null){
			System.out.println(output.data);
			output = output.next;
		}

	}

}
