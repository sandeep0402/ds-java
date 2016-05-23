package ds.trees;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PrintBinartyTreeBottomToTop
{
 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(6);
  Node g = new Node(7);
  Node h = new Node(8);
  a.left = b;
  a.right = c;
  b.left = d;
  c.left = e;
  c.right = f;
  f.left = g;
  f.right = h;
//  		1
//	2 					3
//4					5		6
//						7		8
  
//					1
//			3 				2
//		6		5				4
//	8		7			
  printLevelFromBottomToTop(a);
  mirror(a);
  System.out.println("\n\n\n");
  printLevelFromBottomToTop(a);

 }

 private static void mirror(Node node){
	 if(node==null){
		 return;
	 }
	 Node temp = node.left;
	 node.left = node.right;
	 node.right = temp;
	 mirror(node.left);
	 mirror(node.right);
 }
 private static void printLevelFromBottomToTop(Node root)
 {
  LinkedList < Node > queue=new LinkedList < Node >();
  Stack < Node > stack=new Stack < Node >();
  LinkedList < Node > queueOrder=new LinkedList < Node >();

  queue.add(root);
  while(!queue.isEmpty())
  {
   Node node=queue.poll();
   stack.push(node);
   queueOrder.add(node);

   if(node.left!=null)
   {
    queue.add(node.left);
   }
   if(node.right!=null)
   {
    queue.add(node.right);
   }
  }
  while(!stack.isEmpty())
  {
   System.out.print(stack.pop().value+", ");
  }
  System.out.println("in norml order");
  while(!queueOrder.isEmpty())
  {
   System.out.print(queueOrder.poll().value+", ");
  }
 }


 static class Node
 {
  Node left;
  Node right;
  int value;

  public Node(int value)
  {
   this.value = value;
  }
 }
}