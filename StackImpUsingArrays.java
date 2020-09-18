package main.java.linkedlist;

/**
 * Code to implement stack using arrays
 * 
 * @author mohitjai
 *
 * @param <K>
 */
public class StackImpUsingArrays <K> {
	
	static int max_value = 100;
	static int headPosition = -1;
	static Object [] array = new Object[max_value];
	static Object value;
	
	private void push(K object){
		if(headPosition >= max_value-1){
			System.out.println("Stack is Full");
			return;
		}
		array[++headPosition] = object;
	}
	
	private Object pop(){
		if(headPosition <= 0){
			System.out.println("Stack is Empty");
			return null;
		}
		
		value = array[headPosition--];
		return value;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImpUsingArrays<String> stack = new StackImpUsingArrays<>();
		String value = (String) stack.pop();
		stack.push("Mohit");
		stack.push("Jain");
		stack.push("MohitJain");
		System.out.println("Popped Value..."+stack.pop());
		for(int i=headPosition; i >=0; i--){
			System.out.println(array[i]);
		}
	}

}
