package main.java.linkedlist;
/**
 * Delete Node from a specific position in Singly Linked List
 * Covered cases : handle the situation for first and last position, if head is null, if position is greater than length of the linked list.
 * @author mohijain
 *
 */
public class DeleteNodeLL {

	static Node head;
	Node newNode;

	static class Node {
		int data;
		Node next;

		Node(int i) {
			this.data = i;
			this.next = null;
		}
	}

	private void push(int i) {
		if (head == null) {
			head = new Node(i);
			return;
		}
		newNode = head;
		while (newNode.next != null) {
			newNode = newNode.next;
		}
		newNode.next = new Node(i);
	}

	private void deleteNode(int position) {
		int length = 0;
		Node current = head;
		if(current == null){
			System.out.println("Linkedlist does not contain any nodes please first insert and then try to delete.");
			return;
		}
		while (current != null) {
			current = current.next;
			++length;
		}
		if (length < position) {
			System.out
					.println("Length is smaller than the position which is not the right case");
			return;
		}
		if (position > 0) {
			current = head;
			for (int i = 1; i < position - 1; i++) {
				current = current.next;
			}
			if (current.next.next == null) {
				current.next = null;
			} else {
				current.next = current.next.next;
			}
		} else{
			current = head;
			head = current.next;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeLL rr = new DeleteNodeLL();
		rr.push(1);
		rr.push(2);
		rr.push(3);
		rr.push(4);
		rr.push(5);
		rr.push(6);
		rr.push(7);
		rr.push(8);
		rr.push(9);
		rr.deleteNode(5);
		rr.deleteNode(8);
		rr.deleteNode(0);
		//negative senario 
		rr.deleteNode(15);
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

}
