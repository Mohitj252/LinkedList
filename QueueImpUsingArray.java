package main.java.linkedlist;

/**
 * Implement Queue using Array
 * @author mohitjai
 *
 */
public class QueueImpUsingArray {

	static int front = -1;
	static int rear = -1;
	int max = 5;
	int[] array = new int[max];
	int removedValue;

	private void enqueue(int value) {
		//Check the Queue is full or not
		if ((front == 0 && rear == max-1) || (rear == (front-1))) 
	    { 
	        System.out.println("\nQueue is Full"); 
	        return; 
	    } 
		else if (front == -1) /* Insert First Element */
	    { 
	        front = rear = 0; 
	        array[rear] = value; 
	    } 
		// check when rear is pointing to last index of the array
	    else if (rear == max-1 && front != 0) 
	    { 
	        rear = 0; 
	        array[rear] = value; 
	    } 
	  
	    else
	    { 
	        rear++; 
	        array[rear] = value; 
	    } 

	}

	private int dequeue() {
		//check queue empty condition
		if (front == -1) 
	    { 
	        System.out.println("\nQueue is Empty"); 
	        return 0; 
	    } 
	  
	    int data = array[front]; 
	    array[front] = -1; 
	    if (front == rear) 
	    { 
	        front = -1; 
	        rear = -1; 
	    } 
	    else if (front == max-1) 
	        front = 0; 
	    else
	        front++; 
	  
	    return data; 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueImpUsingArray qUsingArray = new QueueImpUsingArray();
		qUsingArray.enqueue(1);
		qUsingArray.enqueue(2);
		qUsingArray.enqueue(3);
		qUsingArray.dequeue();
		qUsingArray.dequeue();
		System.out.println("rear value...." + rear);
		System.out.println("front value...." + front);
		qUsingArray.enqueue(4);
		qUsingArray.enqueue(5);
		qUsingArray.enqueue(6);
		qUsingArray.enqueue(7);
		qUsingArray.enqueue(8);
		System.out.println("rear value...." + rear);
		System.out.println("front value...." + front);
		qUsingArray.dequeue();
		qUsingArray.dequeue();
		qUsingArray.dequeue();
		qUsingArray.dequeue();
		qUsingArray.dequeue();
		qUsingArray.dequeue();

	}

}
