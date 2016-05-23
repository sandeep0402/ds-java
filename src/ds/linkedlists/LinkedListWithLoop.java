package ds.linkedlists;
public class LinkedListWithLoop {

	/* 
	 * Problem: Find Loop in singly linked list and start element of loop
	 * 
	 * Algorithm: Floyd's algorithm for cycle detection.
	 * Also known as “Tortoise and Hare Algorithm”
	 * 
	 * Solution: We take two pointers, one slow, which moves one node at a time and
	 * another fast, which moves two nodes at a time. Both the pointers start
	 * from head. If the linked list is not looped. fast pointer will hit null
	 * pointer. If they meet, that means the linked list is looped. If it is
	 * looped then both the pointers are at some point in the loop. We keep one
	 * fixed and move another pointer in the loop till both of them meet again.
	 * In this way we will find the length of the loop. Now we take both the
	 * pointer to the head and move the fast pointer 'loop length' ahead of the
	 * slow pointer. Then we again move them one node at a time till they meet.
	 * As the fast pointer is 'loop length' ahead of the slow pointer, when slow
	 * pointer reaches starting of the loop fast will also reach there after
	 * completing one loop. So when these two pointers meet that point will be
	 * the starting point of the loop.
	 */
	public static void main(String[] args) {
		Node head = new Node(1);
		Node middle = head.append(2).append(3).append(4).append(5);
		Node tail = middle.append(6).append(7).append(8).append(9).append(10)
				.append(11);
		tail.next = middle;
		findLoopInformation(head);
	}

	private static void findLoopInformation(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		boolean isLooped = false;
		/*
		 * Step1: Proceed in the usual way u'll use to find the loop. ie. Have
		 * two pointers, increment one in single step and other in two steps, If
		 * they both meet in sometime, there is a loop.
		 */
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				isLooped = true;
				break;
			}
		}
		if (isLooped) {
			System.out.println("Linkedlist is looped");
			fastPointer = fastPointer.next;
			int count = 1;
			/*
			 * Step2: Freeze one pointer where it was and increment the other
			 * pointer in one step counting the steps u make and when they both
			 * meet again, the count will give u the length of the loop.(This is
			 * same as counting the number of elements in a circular link list.)
			 */
			while (slowPointer != fastPointer) {
				fastPointer = fastPointer.next;
				count++;
			}
			System.out.println("Loop length = " + count);

			/*
			 * Step3: Reset both pointers to the start of the link list,
			 * increment one pointer to the length of loop times and then start
			 * the second pointer. increment both pointers in one step and when
			 * they meet again, it'll be the start of the loop. (This is same as
			 * finding the nth element from the end of the link list.)
			 */
			slowPointer = head;
			fastPointer = head;
			while (count-- > 0) {
				fastPointer = fastPointer.next;
			}
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
			System.out.println("Loop starting point = " + slowPointer.value);
		} else {
			System.out.println("Linkedlist is NOT looped");
		}
	}

	private static class Node {
		public Node next;
		public int value;

		public Node(int value) {
			this.value = value;
		}

		public Node append(int value) {
			Node node = new Node(value);
			next = node;
			return node;
		}
	}
}
