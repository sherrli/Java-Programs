//Node class example


public class Node {
	int data;  //every Node object stores a data value
	Node next; //and a pointer to the next Node in a list
	
	//constructor:
	Node(int d, Node n) {
		data = d;
		next = n;
	}
}
