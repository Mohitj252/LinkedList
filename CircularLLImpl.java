package main.java.linkedlist;
/**
 * Circular linked list implementation
 * Covered Use Cases 
 * 1. if we have only one node, remove the node and assign null to the head node.
 * 2. if we need to remove head element, change the next of the last element in the linked list and move head to the current.next.
 * 3. if we need to remove the last element of the linked list, remove the last node and prev node's next points to the head.
 * 
 * @author mohijain
 *
 * @param <K>
 */
public class CircularLLImpl<K> {
	static Node head = null;
	Node prev = null;

	static class Node<K> {
		K data;
		Node next;

		Node(K data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * 
	 * @param value
	 *            value is the data of the node
	 * @param isLastNode
	 *            isLastNode is the boolean parameter, if it is true then it
	 *            indicates it is the last node and should point to the head
	 *            (first) node.
	 * @return return the inserted node
	 */
	private Node push(K value, boolean isLastNode) {
		if (head == null) {
			head = new Node<K>(value);
			head.next = head;
			prev = head;
			return head;
		} else if (isLastNode) {
			prev.next = new Node<K>(value);
			prev = prev.next;
			prev.next = head;
		} else {
			prev.next = new Node<K>(value);
			prev = prev.next;
		}
		return prev;
	}

	/**
	 * 
	 * @param node
	 *            It is the node in the LL from where we will start the
	 *            traverse.
	 */
	private void traverseCLL(Node node) {
		if (node == null) {
			System.out.println("Circular Linked List is Empty");
			return;
		}
		Node<K> temp = node;
		do {
			System.out.println(node.data);
			node = node.next;
		} while (node != temp && node != null);
	}

	private Node deleteLL(int position) {
		int length = 0;
		Node current = head;
		Node lastNode = null;
		if (current == null) {
			System.out.println("Provide the valid input Node");
			return null;
		}
		do {
			lastNode = current;
			current = current.next;
			++length;
		} while (current != head);
		if (position > length) {
			position = position % length;
		}

		current = head;
		if (position > 0) {
			for (int i = 1; i < position - 1; i++) {
				current = current.next;
			}
			if (current.next.next == head) {
				current.next = head;
			} else {
				current.next = current.next.next;
			}
		} else if (position == 0 && length == 1) {
			head = null;
		} else {
			lastNode.next = head.next;
			head = current.next;
		}
		return head;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularLLImpl<Integer> cll = new CircularLLImpl<>();
		head = cll.push(1, false);
		cll.push(2, true);
		// Node node3 = cll.push(3, false);
		// cll.traverseCLL(node3);
		head = cll.deleteLL(2);
		cll.traverseCLL(head);
	}

}
