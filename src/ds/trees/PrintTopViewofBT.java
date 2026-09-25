package ds.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/*
* https://www.hackerrank.com/challenges/tree-top-view/problem?isFullScreen=true
*/ 
public class PrintTopViewofBT {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        //System.out.println("Tree size: " +count);
        Node node = null;
        
        for(int i=0; i<count; i++){
            node = insert(node, sc.nextInt());
            //System.out.println("Tree element: " +node.val);
        }
        Map<Integer, Integer> map = new TreeMap<>();
        topView(node);
        //topView(node, 0, map);
        //System.out.println("size: " +map.size());
        //map.values().stream().forEach(v -> System.out.print(v.intValue()+" "));
    }
    
	static void topView(Node root) {
		if (root == null) {
			return;
		}

    	Map<Integer, Integer> map = new TreeMap<>();
    	Queue<NodeLevel> queue = new LinkedList<>();

    	queue.offer(new NodeLevel(root, 0));

	    while (!queue.isEmpty()) {
	
	        NodeLevel current = queue.poll();
	
	        Node node = current.node;
	        int level = current.level;
	
	        // First node at this horizontal distance
	        if (!map.containsKey(level)) {
	            map.put(level, node.val);
	        }
	
	        if (node.left != null) {
	            queue.offer(new NodeLevel(node.left, level - 1));
	        }
	
	        if (node.right != null) {
	            queue.offer(new NodeLevel(node.right, level + 1));
	        }
	    }
	
	    map.values().forEach(v -> System.out.print(v + " "));
	}
	   
    public static Node insert(Node node, int val){
        if(node == null){
            return new Node(val);
        }
        if(val <= node.val){
            node.left = insert(node.left, val);
        }else{
            node.right = insert(node.right, val);
        }
        return node;
    }
	static class NodeLevel {
	    Node node;
	    int level;
	
	    NodeLevel(Node node, int level) {
	        this.node = node;
	        this.level = level;
	    }
	}
    static class Node {
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val = val;
        } 
    }
}
