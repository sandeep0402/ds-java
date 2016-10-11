package ds.trees;

// http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
class AvlTreeInsertDelete {
 
    static Node root;
 
    // A utility function to get height of the tree
    int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }
 
	private void updateHeight(Node node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}
	
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node node) {
        Node leftChild = node.left;
        Node subTree = leftChild.right;
 
        // Perform rotation
        leftChild.right = node;
        node.left = subTree;
 
        // Update heights
        updateHeight(node);
        updateHeight(leftChild);
 
        // Return new root
        return leftChild;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node node) {
        Node rightChild = node.right;
        Node subTree = rightChild.left;
 
        // Perform rotation
        rightChild.left = node;
        node.right = subTree;
 
        updateHeight(node);
        updateHeight(rightChild);
 
        // Return new root
        return rightChild;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }
 
    Node insert(Node node, int key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null) {
            return (new Node(key));
        }
 
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
 
        updateHeight(node);
 
        /* 3. Get the balance factor of this ancestor node to check whether
         this node became unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
 
        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
 
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
    /* Given a non-empty binary search tree, return the node with minimum
     key value found in that tree. Note that the entire tree does not
     need to be searched. */
    Node minValueNode(Node node) {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
 
        return current;
    }
 
    Node deleteNode(Node node, int key) {
 
        // STEP 1: PERFORM STANDARD BST DELETE
        if (node == null) {
            return node;
        }
 
        // If the key to be deleted is smaller than the root's key,
        // then it lies in left subtree      
        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            // If the key to be deleted is greater than the root's key,
            // then it lies in right subtree
        	node.right = deleteNode(node.right, key);
        } 
         
        // if key is same as root's key, then this is the node
        // to be deleted
        else {
    		//Case 1: if node to be deleted has no children
    		if(node.left==null && node.right==null){
    			node = null;
    		}
    		//Case 2 : if node to be deleted has only one child
    		// if right is null then set left as value
    		else if(node.right == null){
    			node = node.left;
    		}
    		//Case 2 : if node to be deleted has only one child
    		// if left is null then set right as value		
    		else if(node.left == null){
    			node = node.right;
    		}
    		//Case 3 : if node to be deleted has both children
    		// find a minimum value in the right subtree;
    		// replace value of the node to be removed with found minimum. Now, right subtree contains a duplicate!
    		// apply remove to the right subtree to remove a duplicate.
    		else if(node.left!=null && node.right!=null){
    			
    			//now we have found the minimum element in the right sub tree
    			Node successor	 = minValueNode(node);
    			 // Copy the inorder successor's data to this node
                node.key = successor.key;
 
                // Delete the inorder successor
                node.right = deleteNode(node.right, successor.key);

    		}		
//            // node with only one child or no child
//            if ((node.left == null) || (node.right == null)) {
//                Node temp = null;
//                if (temp == node.left) {
//                    temp = node.right;
//                } else if (temp == node.right){
//                    temp = node.left;
//                }
// 
//                // No child case
//                if (temp == null) {
//                    temp = node;
//                    node = null;
//                } else // One child case
//                {
//                    node = temp; // Copy the contents of the non-empty child
//                }
//            } else {
// 
//                // node with two children: Get the inorder successor (smallest
//                // in the right subtree)
//                Node temp = minValueNode(node.right);
// 
//                // Copy the inorder successor's data to this node
//                node.key = temp.key;
// 
//                // Delete the inorder successor
//                node.right = deleteNode(node.right, temp.key);
//            }
        }
 
        // If the tree had only one node then return
        if (node == null) {
            return node;
        }
 
        updateHeight(node);
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
 
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        return node;
    }
 
    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
 
    public static void main(String[] args) {
        AvlTreeInsertDelete tree = new AvlTreeInsertDelete();
 
        /* Constructing tree given in the above figure */
        root = tree.insert(root, 9);
        root = tree.insert(root, 5);
        root = tree.insert(root, 10);
        root = tree.insert(root, 0);
        root = tree.insert(root, 6);
        root = tree.insert(root, 11);
        root = tree.insert(root, -1);
        root = tree.insert(root, 1);
        root = tree.insert(root, 2);
 
        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \ 
       0    5    11 
      /    /  \
    -1   2    6
         */
        System.out.println("The preorder traversal of constructed tree is : ");
        tree.preOrder(root);
 
        root = tree.deleteNode(root, 10);
 
        /* The AVL Tree after deletion of 10
           1
          /  \
         0    9
        /     / \  
       -1    5   11  
      /  \
     2    6
         */
        System.out.println("");
        System.out.println("Preorder traversal after deletion of 10 :");
        tree.preOrder(root);
    }
    
class Node {
	int key, height = 0;
	Node left, right;
	
	Node(int d) {
		key = d;
		height = 1;
	}
}
}