package ds.linkedlists;

public class MultiplyTwoLinkedLists<T> {

    private Node<T> head;
    private Node<T> tail;

    public void add(T element) {
        Node<T> node = new Node<T>();
        node.setValue(element);
        if (head == null) {
            head = node; // since there is only one element, both head and
            tail = node; // tail points to the same object.
        } else {
            tail.setNext(node);  // set current tail next link to new node
            tail = node;            // set tail as newly created node
        }
    }
    
    public Node<T> getNodeAtPos(int position){
        Node<T> node = head;
        int count = 0;
        while(node != null){
            if(position == count){
                return node;
            }
            count++;
            node = node.getNext();
        }
        if(node == null){
            add(null);
        }
        return tail;
    }

    public void addTwoLists(MultiplyTwoLinkedLists<Integer> result, MultiplyTwoLinkedLists<Integer> list1, MultiplyTwoLinkedLists<Integer> list2) {
        Node<Integer> node1 = list1.head;
        Node<Integer> node2 = list2.head;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int sum = carry;
            sum += node1!= null ? node1.getValue() : 0;
            sum += node2!= null ? node2.getValue() : 0;
            
            if (sum > 9) {
                carry = sum / 10;
                //System.out.println("before Sum = "+sum+", carry="+carry);
                sum = sum % 10;
                //System.out.println("After Sum = "+sum+", carry="+carry);
            } else {
                carry = 0;
            }
//            System.out.println("Adding node = "+sum);
            result.add(sum);
            node1 = node1!= null ? node1.getNext() : null;
            node2 = node2!= null ? node2.getNext() : null;
        }
        if (carry > 0) {
            result.add(carry);
        }
    }

    /*
    Incomplete
    */
    public void multiplyTwoLists(MultiplyTwoLinkedLists<Integer> result, MultiplyTwoLinkedLists<Integer> list1, MultiplyTwoLinkedLists<Integer> list2) {
        Node<Integer> node1 = list1.head;
        Node<Integer> node2 = list2.head;
        int carry = 0;
        int outerCounter = 0;
        while(node1 != null){
            node2 = list2.head;
            carry = 0;
            int innerCounter = outerCounter;            
            while(node2 != null){
                Node<Integer> node = result.getNodeAtPos(innerCounter);
                int existingNodeVal = node.getValue()!= null? node.getValue():0;
                int product = (node1.getValue() * node2.getValue() +carry) + existingNodeVal ;
                System.out.println("node1.getValue() = "+node1.getValue() + ", node2.getValue() = "+ node2.getValue()+", product = "+ product);
                if (product > 9) {
                    carry = product / 10;
                    product = product % 10;
                    //System.out.println("After Sum = "+sum+", carry="+carry);
                } else {
                    carry = 0;
                }
                node.setValue(product);
                System.out.println("loc = "+innerCounter+" num="+product+", carry="+carry);
                node2 = node2.getNext();
                innerCounter++;
            }
            if(carry > 0){
                result.getNodeAtPos(innerCounter).setValue(carry);
            }
            node1 = node1.getNext();
            outerCounter++;
        }
    }
    
    public static void main(String[] args) {
        MultiplyTwoLinkedLists<Integer> list1 = new MultiplyTwoLinkedLists<Integer>();
        MultiplyTwoLinkedLists<Integer> result = new MultiplyTwoLinkedLists<Integer>();
        MultiplyTwoLinkedLists<Integer> list2 = new MultiplyTwoLinkedLists<Integer>();        
        // 617 + 295 = 912 
        //  7 ->1->6 + 5->9->2 = 2->1->9
//        list1.add(7);
//        list1.add(1);
//        list1.add(6);
//        list2.add(5);
//        list2.add(9);
//        list2.add(2);
//        result.addTwoLists(result, list1, list2);
        list1.add(3);
        list1.add(7);
        list1.add(9);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(2);
        result.multiplyTwoLists(result, list1, list2);
        list1.traverse();
        list2.traverse();
        result.traverse();
    }

    public void traverse() {
        System.out.println("List Is: ");

        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " | ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    static class Node<T> implements Comparable<T> {

        private T value;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> ref) {
            this.next = ref;
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
}
