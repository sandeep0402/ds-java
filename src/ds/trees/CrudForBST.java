package ds.trees;

/*
 * Reference
 * http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 */
public class CrudForBST {
	public static  Node root;
	public CrudForBST(){
		this.root = null;
	}
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	// By Sandeep: optimized and refactored
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		if(root == null){
			return false;
		}
		while(current.data != id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			resetNode(parent, current, isLeftChild, null);
		}
		//Case 2 : if node to be deleted has only one child
		// if right is null then set left as value
		else if(current.right == null){
			resetNode(parent, current, isLeftChild, current.left);
		}
		//Case 2 : if node to be deleted has only one child
		// if left is null then set right as value		
		else if(current.left == null){
			resetNode(parent, current, isLeftChild, current.right);
		}
		//Case 3 : if node to be deleted has both children
		// find a minimum value in the right subtree;
		// replace value of the node to be removed with found minimum. Now, right subtree contains a duplicate!
		// apply remove to the right subtree to remove a duplicate.
		else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			resetNode(parent, current, isLeftChild, successor);		
			successor.left = current.left;

		}		
		return true;		
	}

	private void resetNode(Node parent, Node current, boolean isLeftChild,
			Node successor) {
		if(root == current){
			root = successor;
		}else if(isLeftChild){
			parent.left = successor;
		}else{
			parent.right = successor;
		}
	}
	
	public Node getSuccessor(Node node){
		Node successor = null;
		Node parent =null;
		Node current = node.right;
		while(current != null){
			parent = successor;
			successor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successor!=node.right){
			parent.left = successor.right;
			successor.right = node.right;
		}

		return successor;
	}
	public void insert(int id){
        root = insert(root, id);
     }
     /* Function to insert data recursively */
     private Node insert(Node node, int data)
     {
         if (node == null)
             node = new Node(data);
         else
         {
             if (data <= node.data)
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     
 	public void insertWithLoop(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public static void main(String arg[]){
		CrudForBST b = new CrudForBST();
		b.insert(3);
		b.insert(8);
		b.insert(1);
		b.insert(4);
//		b.insert(6);b.insert(2);b.insert(10);b.insert(9);
//		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(3));		
		b.display(root);
	}
}

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
	@Override
	public String toString(){
		return this.data+ "";
	}
}