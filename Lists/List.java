/* A Generic singly Linked List ADT for Lab 6 of Data Structures course.
 * Reference types must be passed as parameters.
 * Allowed to include methods not in ListInterface.java, like equals() and toString().
 */

import java.util.*;

@SuppressWarnings("overrides")
public class List<T> implements ListInterface<T>{

	private class Node{
		// private classes automatically have private fields
		T item;
		Node next; // don't do Node<T> next; Node is inside the Generic List class, its item will be type T
		// Node constructor
		Node(T item){
			this.item = item;
			next = null;
		}
	}

	// List fields
	private Node head;
	private int numItems;
  
	// List constructor
	public List(){
		head = null;
		numItems = 0;
	}

	// find()
	// private helper function to return a reference to the Node at index
	private Node find(int index){
		Node N = head;
		for(int i=1; i<index; i++){
			N=N.next;
		}
		return N;
	}

	// ADT operations ---------------------------------
	
	// isEmpty
	// pre: none
	// post: returns true if this List is empty, false otherwise
	public boolean isEmpty(){
		return (numItems==0);
	}

	// size
	// pre: none
	// post: returns the number of elements in this List
	public int size(){
		return numItems;
	}

	// get
	// pre: 1 <= index <= size()
	// post: returns item at position index
	public T get(int index) throws ListIndexOutOfBoundsException{
		if( index<1 || index>numItems){
			throw new ListIndexOutOfBoundsException("get(): invalid index: " + index);
		}
		Node N = find(index);
		// item should be type T
		return N.item;
	}

	// add
	// inserts newItem in this List at position index
	// pre: 1 <= index <= size()+1
	// post: !isEmpty(), items to the right of newItem are renumbered
	public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
		if( index<1 || index>numItems+1 ){
			throw new ListIndexOutOfBoundsException("add(): invalid index: " + index);
		}

		// special case: adding to head or List is empty (head is null)
		if(index==1){
			Node N = new Node(newItem);
			N.next = head;
			head = N;
		}else{ // List already has items, works for tail adds too
			Node base = find(index-1);
			Node temp = base.next; // temp is null if insert at end
			Node inserted = new Node(newItem);
			base.next = inserted;
			inserted.next = temp;
		}
		numItems++;
	}

	// remove
	// deletes item from position index
	// pre: 1 <= index <= size()
	// post: items to the right of deleted item are renumbered
	public void remove(int index) throws ListIndexOutOfBoundsException{
		if( index<1 || index>numItems){
			throw new ListIndexOutOfBoundsException("remove(): invalid index: " + index);
		}

		// special case: removing head item
		if(index==1){
			Node N = head;
			head = head.next;
			N.next = null; // remove reference that original head stored
		}else{
			Node before = find(index-1); // altering references
			Node toDelete = before.next; // toDelete.next is null if deleting tail Node
			before.next = toDelete.next; // before.next is last item if ^
			toDelete.next = null; // get rid of reference
			// Java garbage collector sets toDelete = null
		}
		numItems--;
	}

	// removeAll
	// pre: none
	// post: isEmpty()
	public void removeAll(){
		head = null;
		numItems = 0;
	}

	// equals()
	// pre: none
	// post: returns true if this List matches rhs, false otherwise
	// Overrides Object's equals() method
	@SuppressWarnings("unchecked")
	public boolean equals(Object rhs){
	//" rhs instanceof List<T> " does not work for parameterized types
		boolean eq = false;
		List<T> R = null;
		// can only compare things that are same type
		if( this.getClass()==rhs.getClass() ){
			R = (List<T>) rhs;
			// must be same size
			if( this.size() != R.size() ){ return eq; }
			// check each item in the two lists
			for(int i=1; i<=this.numItems; i++){
				if( !(this.get(i).equals(R.get(i))) ){
					return eq;
				}
			}
			eq = true;
		}
		return eq;
	}

	// toString()
	// pre: none
	// post: return a String of the current state of the Linked List
	// Overrides Object's toString() method
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Node N;
		for(N=head; N!=null; N=N.next){
			// sb.append(Object obj) will call valueOf(obj) which returns the string representation of obj's value
			sb.append(N.item).append(" ");
			// can add a condition that if N.next==null then do not append the last space " "
		}
		return new String(sb);
	}
}
