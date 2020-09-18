package main.java.linkedlist;

/**
 * Implementation of the queue using Linked List
 * @author mohitjai
 *
 * @param <K>
 */
public class QueueImplUsingLL<K> {
	static Node head;
	Node prev;
	Object value;

	static class Node<K> {
		K data;
		Node next;

		Node(K i) {
			this.data = i;
			this.next = null;
		}
	}

	private void enqueue(Object i) {
		if (head == null) {
			head = new Node(i);
			prev = head;
			return;
		}
		prev.next = new Node(i);
		prev = prev.next;
	}

	private Object dequeue() {
		if (head == null) {
			return 0;
		}
		value = head.data;
		head = head.next;
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueImplUsingLL<String> siuLL = new QueueImplUsingLL<>();
		Object t = siuLL.dequeue();
		System.out.println(t);
		siuLL.enqueue("MOHIT");
		siuLL.enqueue("JAIN");
		siuLL.enqueue("MOHITJAIN");
		siuLL.dequeue();
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

}
