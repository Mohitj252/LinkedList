package main.java.linkedlist;

/**
 * 
 * Code for Stack implementation using Linked list
 * 
 * @author mohitjai
 *
 * @param <K>
 */
public class StackImpUsingLL<K> {
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
		newNode = new Node(i);
		newNode.next = head;
		head = newNode;
	}

	private Object pop() {
		if (head == null) {
			return 0;
		}
		value = head.data;
		head = head.next;
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackImpUsingLL<String> siuLL = new StackImpUsingLL<>();
		Object t = siuLL.pop();
		System.out.println(t);
		siuLL.push("MOHIT");
		siuLL.push("JAIN");
		siuLL.push("MOHITJAIN");
		siuLL.pop();
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

}
