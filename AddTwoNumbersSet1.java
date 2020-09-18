package main.java.linkedlist;

// 
/**
 * Adding two numbers using a constant space. Taking three string objects to save the input (input1 and input2) 
 * and result values
 * @author mohitjai
 *
 */
public class AddTwoNumbersSet1 {
	Node node1;
	Node node2;
	static Node head1;
	static Node head2;
	static Node resultList;
	static Node resultHead;
	static String list1Data = "";
	static String list2Data = "";
	static String finalData;

	static class Node {
		Integer data;
		Node next;

		Node(int i) {
			this.data = i;
			next = null;
		}
	}

	private void insert(int i, int listNumber) {
		if (listNumber == 1) {
			if (head1 == null) {
				node1 = new Node(i);
				head1 = node1;
				return;
			}
			while (node1.next != null) {
				node1 = node1.next;
			}
			node1.next = new Node(i);
		} else {
			if (head2 == null) {
				node2 = new Node(i);
				head2 = node2;
				return;
			}
			while (node2.next != null) {
				node2 = node2.next;
			}
			node2.next = new Node(i);
		}

	}

	private void printLL(Node ll1, Node ll2) {
		if (ll1 != null) {
			while (ll1 != null) {
				// list1 data adding to String
				list1Data = list1Data.concat(Integer.toString(ll1.data));
				System.out.print(ll1.data);
				if (ll1.next != null) {
					System.out.print(",");
				}
				ll1 = ll1.next;
			}
		}
		System.out.println();
		if (ll2 != null) {
			while (ll2 != null) {
				// list2 data adding to String
				list2Data = list2Data.concat(Integer.toString(ll2.data));
				System.out.print(ll2.data);
				if (ll2.next != null) {
					System.out.print(",");
				}
				ll2 = ll2.next;
			}
			System.out.println();
		}
	}

	private String addNumbers(String list1, String list2) {
		return Integer.toString(Integer.parseInt(list1)
				+ Integer.parseInt(list2));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddTwoNumbersSet1 addTwoNums = new AddTwoNumbersSet1();
		// list 1 data 1248
		addTwoNums.insert(1, 1);
		addTwoNums.insert(2, 1);
		addTwoNums.insert(4, 1);
		addTwoNums.insert(8, 1);
		// list 2 data 86
		addTwoNums.insert(8, 2);
		addTwoNums.insert(6, 2);

		addTwoNums.printLL(head1, head2);
		// add two numbers of list1Data and list2Data
		finalData = addTwoNums.addNumbers(list1Data, list2Data);
		for (int i = 0; i < finalData.length(); i++) {
			if (resultList == null) {
				resultList = new Node(Character.getNumericValue(finalData
						.charAt(i)));
				resultHead = resultList;
				continue;
			}
			while (resultList.next != null) {
				resultList = resultList.next;
			}
			resultList.next = new Node(Character.getNumericValue(finalData
					.charAt(i)));
		}
		resultList = resultHead;
		while (resultList != null) {
			System.out.print(resultList.data);
			resultList = resultList.next;
		}

	}

}
