/* LinkedList.java
 * This file includes functions that push, pop, find, and insert Nodes using the queue implementation of a linked list.
 */

public class LinkedList {
	Node head; //head represents front of list
	int size;  //represents the number of elements in the list

	//append a new node to the end of the list
	public void push(int a) {
		//create a dummy pointer to traverse the list, and find the end
		if (size == 0) {
			head = new Node(a, null);
		}
		else {
			Node addToBack = new Node(a, null);
			Node p = head;
			//make sure p is pointing to a Node with nothing after it
			while (p.next != null) {
				p = p.next;
			}	
			p.next = addToBack;
			//changing p.next changes head as well
		}
		size++;			
	}
	
	//remove and return the first node in the list
	public int pop() {
		if (size==0) {
			return 0;
		}
		else {
			//create a temp variable pointing to the same node that head points at
			Node p = head;
			//let head point to the next node in the list, original head is not part of the list anymore
			head = head.next;
			//original head.data is not deleted because p is pointing to it
			size--;
			return p.data;
		}
	}	

	//recursively insert a node with data d into index n (first index 1 not 0) (will pass Node head to Node a)
	public void insert(int n, int d, Node a) {
		if (n==1) {
			Node nodeToInsert = new Node(d, null);
			//create temp pointer to a so that the rest of the list is not lost
			Node temp = a;
			//changes to a do not change temp
			a = nodeToInsert;
			a.next = temp;
			size++;
		}
		else if (n==2) {
			 //by this stage, a references the n-1th Node in the list
			Node nodeToInsert = new Node(d, null);
			Node temp = a.next;
			a.next = nodeToInsert;
			a.next.next = temp;
			size++;
		}
		else if (n>2 && a.next!=null) {
			insert(n-1, d, a.next);
		}
		else {
			System.out.println("Invalid insertion index");
		}
	}

	//recursively find and return the nth index item
	public int find(int n, Node a) {
		if (size == 0) {
			//the linked list is empty
			return -1;
		}
		else if (n==1) {
			return a.data;
		}
		else if (n!=1 && a.next!=null) {
			return find(n-1, a.next);
		}
		else {
			//node at index n was never found
			return -1;
		}
	}

}

