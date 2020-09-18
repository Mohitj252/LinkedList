package main.java.linkedlist;

/**
 * Clone a Linked List and the list node having the next node and random node reference.
 * 
 * @author mohitjai
 *
 */
public class CloneLL {
	
	static class LLNode{
		int data;
		LLNode next;
		LLNode random;
		
		LLNode(int data){
			this.data = data;
			next = null;
			random = null;
		}
	}
	
	private LLNode cloneLinkedList (LLNode n){
		if(n == null){
			return n;
		}
		LLNode nCurrent = n;
		LLNode temp;
		//insert the new elements 1 -> 1` -> 2 -> 2` ->3 -> 3` -> 4 -> 4`
		while(nCurrent != null){
			temp = new LLNode(nCurrent.data);
			temp.next = nCurrent.next;
			nCurrent.next = temp;
			nCurrent = temp.next;
		}
		
		nCurrent = n;
		//Random pointer modification for 1`, 2`, 3`, 4`
		while(nCurrent != null){
			//if original randam variable of a node is null then no need to update random variable of the clone LL
			if(nCurrent.random != null)
			nCurrent.next.random = nCurrent.random.next;
			nCurrent = nCurrent.next.next;
		}
		
		//separate copy of original and the clone
		
		LLNode copy = n.next;
		nCurrent =n; 
		LLNode tmp;
		while(nCurrent.next != null){
			tmp = nCurrent.next;
			nCurrent.next = nCurrent.next.next;
	        nCurrent = tmp;
			
		}
		
		
		return copy;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LLNode head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.random = head;
		head.next.next.next = new LLNode(4);
		head.next.random = head.next.next.next;
		
		CloneLL cll = new CloneLL();
		LLNode cloneCopy = cll.cloneLinkedList(head);
		while(cloneCopy != null){
			System.out.println(cloneCopy.data + ",");
			System.out.println(cloneCopy.random);
			cloneCopy = cloneCopy.next;
		}
		
		
		

	}

}
