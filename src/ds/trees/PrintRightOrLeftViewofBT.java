package ds.trees;
/*
    Print Left View of a Binary Tree
    or Print Right View of a Binary Tree
    http://www.geeksforgeeks.org/print-left-view-binary-tree/
*/
public class PrintRightOrLeftViewofBT {
        static int  MAX_LEVEL = 0;

        private void printLeftView(Node node){
            MAX_LEVEL = 0;
            printLeftView(node, 1);
        }
	private void printLeftView(Node node, int level) {
		if (node == null) {
                    return;
                }
		if (MAX_LEVEL < level) {
                    process(node);
                    MAX_LEVEL = level;
                }
                //System.out.println("node :"+node.data +", level="+level); 
                printLeftView(node.left, level+1);
                printLeftView(node.right, level+1);
		
	}

        private void printRightView(Node node){
            MAX_LEVEL = 0;
            printRightView(node, 1);
        }
	private void printRightView(Node node, int level) {
		if (node == null) {
                    return;
                }
		if (MAX_LEVEL < level) {
                    process(node);
                    MAX_LEVEL = level;
                }
                printRightView(node.right, level+1);
                printRightView(node.left, level+1);                
		
	}        
	private void process(Node node) {           
                System.out.println(node.data);
	}

	public static void main(String[] args) {
            /*
                left view:  5 10 20 45
                right view: 5 15 35 45
            */
		Node root = new Node(5);
		root.left = new Node(10);   
		root.right = new Node(15);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.left = new Node(20);   
		root.left.right = new Node(25);                   
                root.left.right .right= new Node(45);                   
		PrintRightOrLeftViewofBT p = new PrintRightOrLeftViewofBT();
                System.out.println("left view :");                
                //p.printLeftView(root);
                System.out.println("right view :");                
                p.printRightView(root);
	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

}