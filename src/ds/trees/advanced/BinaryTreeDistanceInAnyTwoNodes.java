package ds.trees.advanced;

/*
 * http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/
 * tree example image:  http://algorithms.tutorialhorizon.com/files/2014/12/Distance-betweeb-two-nodes-example-1.png
 */
public class BinaryTreeDistanceInAnyTwoNodes {

    /*
     * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
            'n1' and 'n2' are the two given keys
            'root' is root of given Binary Tree.
            'lca' is lowest common ancestor of n1 and n2
            Dist(n1, n2) is the distance between n1 and n2.
     */
    public int findDistance(Node root, int n1, int n2) {
        int x = Pathlength(root, n1) - 1;
        int y = Pathlength(root, n2) - 1;
        int lcaNode = findLCA(root, n1, n2).data;
        int lcaDistance = Pathlength(root, lcaNode) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public int Pathlength(Node root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
                    || (x = Pathlength(root.right, n1)) > 0) {
                // System.out.println(root.data);
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public Node findLCA(Node node, int n1, int n2) {
        if (node != null) {
            if (node.data == n1 || node.data == n2) {
                return node;
            }
            Node left = findLCA(node.left, n1, n2);
            Node right = findLCA(node.right, n1, n2);

            if (left != null && right != null) {
                return node;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.right.right = new Node(45);
        BinaryTreeDistanceInAnyTwoNodes i = new BinaryTreeDistanceInAnyTwoNodes();
        System.out.println("Distance between 45 and 20 is : "
                + i.findDistance(root, 45, 20));
    }
}
