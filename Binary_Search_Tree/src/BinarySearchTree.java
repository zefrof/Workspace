import java.util.ArrayList;
import java.util.Iterator;

/**
 * A Binary Search Tree is a binary tree that has the property that for any 
 * given node A in the tree, the value of the nodes in the left subtree are
 * less than the value of node A and the value of the nodes in the right subtree 
 * are greater than the value of node A.
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T> {

	Node first;
	ArrayList<T> treeList;
	public BinarySearchTree(){
		first = root;
		treeList = new ArrayList<T>();
	}
	
   /**  
    * Returns an iterator that represents an inorder traversal on this binary tree.  
    *
    * @return an iterator over the elements of this binary tree
    */
   @Override
   public Iterator<T> iteratorInOrder() {
      inOrder(first);
      ArrayList<T> temp = treeList;
      treeList.clear();
	  return temp.iterator();
   }
   
   public void inOrder(Node n){
	   if(n == null){
		   return; 
	   }
	   inOrder(n.getLeft());
	   treeList.add(n.getElement());
	   inOrder(n.getRight());
   }

   /**  
    * Returns an iterator that represents a preorder traversal on this binary tree. 
    *
    * @return an iterator over the elements of this binary tree
    */
   @Override
   public Iterator<T> iteratorPreOrder() {
	   preOrder(first);
	   ArrayList<T> temp = treeList;
	   treeList.clear();
	   return temp.iterator();
   }
   
   public void preOrder(Node n){
	   if(n == null){
		   return;
	   }
	   treeList.add(n.getElement());
	   preOrder(n.getLeft());
	   preOrder(n.getRight());
   }

   /**  
    * Returns an iterator that represents a postorder traversal on this binary tree. 
    *
    * @return an iterator over the elements of this binary tree
    */
   @Override
   public Iterator<T> iteratorPostOrder() {
	   postOrder(first);
	   ArrayList<T> temp = treeList;
	   treeList.clear();
	   return temp.iterator();
   }
   
   /**
    * This is a helper method for iteratorPostOrder
    */
   public void postOrder(Node n){
	   if(n == null){
		   return;
	   }
	   preOrder(n.getLeft());
	   preOrder(n.getRight());
	   treeList.add(n.getElement());
   }

   /** 
    * Removes and returns the specified element from this tree. 
    *
    * @param targetElement the element to be removed from the tree
    * @return the element to be removed from the tree
    */
   @Override
   public T removeElement(T targetElement) {
	   Node temp = this.findNode(targetElement);
	   if(temp == null){
		   return null;
	   } else if ((temp.getLeft() == null) && (temp.getRight() == null)){
		   T val = temp.getElement();
		   temp = null;
		   return val;
	   } else {
		   return null;
	   }
   }
   

   /** 
    * Returns the node with the largest element in the subtree rooted at 
    * the given node. 
    * 
    * @return the node with the largest element in the subtree
    */
   @Override
   protected Node getMaxNode(Node node) {
      if(node == null){
    	  return null;
      }
      if(node.getRight() == null){
    	  return node;
      }
      return getMaxNode(node.getRight());
   }

   /** 
    * Returns true if the binary tree contains an element that matches
    * the specified element and false otherwise. 
    *
    * @param targetElement the element being sought in the tree
    * @return true if the tree contains the target element
    */
   @Override
   public boolean contains(T targetElement) {
      if(first == null){
    	  return false;  
      }
      ArrayList<T> temp = new ArrayList<T>();
      this.toList(first, temp);
      return temp.contains(targetElement);
   }
}