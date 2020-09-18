package main.java.linkedlist;
/**
 * 
 * Code to covert Tree to Doubly Linked List.
 * @author mohitjai
 *
 */
public class TreeToDLL {
	
	static LinkedListNode head = null;
	LinkedListNode prev = null;
	static class LinkedListNode {
		int value;
		LinkedListNode next;
		LinkedListNode prev;
		LinkedListNode(int value){
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	private void ConvertTreetoLinkedList(TreeNode root){
		if(root == null){
			return;
		}
		ConvertTreetoLinkedList(root.left);
		LinkedListNode new_node = new LinkedListNode(root.value);
		if(head == null){
			head = new_node;
			prev = head;
		} else {
			prev.next = new_node;
			new_node.prev = prev;
			prev = new_node;
		}
		ConvertTreetoLinkedList(root.right);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(50);
		
		TreeToDLL treeToDll = new TreeToDLL();
		treeToDll.ConvertTreetoLinkedList(root);
		
		while (head != null){
			System.out.print(head.value);
			if(head.next != null){
				System.out.print("->");
			}
			head = head.next;
			
		}

	}

}
