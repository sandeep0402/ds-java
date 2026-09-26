package ds.trees;

import java.util.*;

/*
* https://www.naukri.com/code360/problems/bottom-view-of-binary-tree_893110
*/
public class PrintBottomViewofBT {

    public static List<Integer> bottomView(TreeNode root) {
        Map<Integer, Pair> map = new TreeMap<>();
        bottomView(root, 0, 0, map);
        List<Integer> results = new ArrayList<>();

        for(Pair pair: map.values()){
            results.add(pair.getval());
        }
        return results;
    }
    private static void bottomView(TreeNode node, int depth, int column, Map<Integer, Pair> map){
        if(node == null){
            return;
        }
        Pair old = map.get(column);
        if(old == null || old.depth <= depth){
            map.put(column, new Pair(depth, node.val));
        }

        bottomView(node.left, depth+1, column-1, map);
        bottomView(node.right,depth+1, column+1, map);
    }
   


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		// root.left.left.right = new Node(10);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(11);

		/*
				7
			3		
				11
		1
				5
			2		10
				4
					8
		
		
		8	4	10	11	3	7
		*/
		
		/*
				7
			3		
				11
		1
				5
			2		
				4
					8
		
		
		8	4	2	11	3	7
		*/
		System.out.println(bottomView(root));
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
    
     static class Pair{
        private int depth;
        private int val;
        Pair(int depth, int val){
            this.depth = depth;
            this.val = val;
        }
        private int getval(){
            return val;
        }

    }

}
