package ds.linkedlists;

public class SinglyLinkedListImpl<T> {

	private Node<T> head;
	private Node<T> tail;

	public void add(T element) {

		Node<T> node = new Node<T>();
		node.setValue(element);
		System.out.println("Adding: " + element);
		/**
		 * check if the list is empty
		 */
		if (head == null) {
			// since there is only one element, both head and
			// tail points to the same object.
			head = node;
			tail = node;
		} else {
			// set current tail next link to new node
			tail.setNextRef(node);
			// set tail as newly created node
			tail = node;
		}
	}

	public void addAfter(T element, T after) {

		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (true) {
			if (tmp == null) {
				break;
			}
			if (tmp.compareTo(after) == 0) {
				// found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if (refNode != null) {
			// add element after the target node
			Node<T> nd = new Node<T>();
			nd.setValue(element);
			nd.setNextRef(tmp.getNextRef());
			if (tmp == tail) {
				tail = nd;
			}
			tmp.setNextRef(nd);

		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void addAtStart(T element){
		Node<T> node = new Node<T>();
		node.setValue(element);
		if(head == null){
			head = node;
			tail = node;
		}else{
			node.setNextRef(head);
			head = node;
		}
	}
	
	public void addAtEnd(T element){
		Node<T> node = new Node<T>();
		node.setValue(element);
		if(head == null){
			head = node;
			tail = node;
		}else{
			tail.setNextRef(node);
			tail = node;
		}
	}
	
	public void AddAtPosition(T element, int position){
		Node<T> node = new Node<T>();
		node.setValue(element);
		Node<T> temp = head;
		int counter = 0;
		position--;
		while(temp != null){
			if (position < 0 || counter == position){
				break;
			}else{
				counter++;
				temp = temp.getNextRef();
			}
		}
		// if temp node is equal to head and position is not 0 position. Means for negative and first position
		// counter will be 0 so need to differentiate that when pos 1 is supplied then element not adds at 0 pos
		if(temp == head && position < 0){
			node.setNextRef(head);
			head = node;
		} else	if(temp != null){
			node.setNextRef(temp.getNextRef());
			temp.setNextRef(node);
			
		}
	}
	
	
	public void deleteFront() {

		if (head == null) {
			System.out.println("Underflow...");
		}
		Node<T> tmp = head;
		head = tmp.getNextRef();
		if (head == null) {
			tail = null;
		}
		System.out.println("Deleted: " + tmp.getValue());
	}

	public void deleteAfter(T after) {

		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while (tmp != null) {
			if (tmp.compareTo(after) == 0) {
				// found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if (refNode != null) {
			tmp = refNode.getNextRef();
			refNode.setNextRef(tmp.getNextRef());
			if (refNode.getNextRef() == null) {
				tail = refNode;
			}
			System.out.println("Deleted: " + tmp.getValue());
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	public void traverse() {
		System.out.println("List Is: ");

		Node<T> tmp = head;
		while (tmp != null) {
			System.out.print(tmp.getValue() + " | ");
			tmp = tmp.getNextRef();
		}
		System.out.println();
	}
	
	public void reverseLinkedListIterative(){
		Node<T> current = head;
		Node<T> next = null;
		Node<T> prev = null;
		while(current != null){
			next = current.getNextRef();
			current.setNextRef(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public void reverseKNodes(int k){
		Node<T> current = head;
		Node<T> next = null;
		Node<T> prev = null;
		int count = 0;
		while(current != null && count < k){
			next = current.getNextRef();
			current.setNextRef(prev);
			prev = current;
			current = next;
			count++;
		}
//		System.out.println("prev " + prev.getValue());
//		System.out.println("current " + current.getValue());
//		System.out.println("next " + next.getValue());

		Node<T> oldHead = head;
		head.setNextRef(current);
		head = prev;
	}
	
	public void reverseLinkedListRecursively(){
		head = reverseUsingRecursion( null, head);
	}

	public Node<T> reverseUsingRecursion(Node<T> prev, Node<T> current){
		
		Node<T> next = current.getNextRef();
		current.setNextRef(prev);

		if(next == null){
			return current;
		}else {
			return reverseUsingRecursion(current, next); // Node becomes prev and next becomes current
		}
	}
	public static void main(String a[]) {
		
		SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl<Integer>();
		linkedList.add(3);
		linkedList.add(32);
		linkedList.add(54);
		linkedList.add(89);
		linkedList.addAfter(76, 54);
		linkedList.deleteFront();
		linkedList.deleteAfter(76);
		linkedList.addAtStart(11);
		linkedList.addAtEnd(9999);
		linkedList.AddAtPosition(123456, 0);
		linkedList.traverse();
		linkedList.reverseLinkedListIterative();
		linkedList.traverse();
		linkedList.reverseLinkedListRecursively();
		linkedList.traverse();
		linkedList.reverseKNodes(3);
		linkedList.traverse();

	}
}

class Node<T> implements Comparable<T> {

	private T value;
	private Node<T> nextRef;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node<T> ref) {
		this.nextRef = ref;
	}

	@Override
	public int compareTo(T arg) {
		if (arg == this.value) {
			return 0;
		} else {
			return 1;
		}
	}
}