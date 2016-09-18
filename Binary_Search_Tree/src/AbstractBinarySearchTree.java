import java.util.ArrayList;
import java.util.Iterator;

/**
 * AbstractBinarySearchTree defines the methods required in a binary search tree.
 */
public abstract class AbstractBinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	/** Tree node containing an element, a left child, and a right child. */
	protected class Node {
	protected T element;
	protected Node left, right;

	/**
	 * Creates a new tree node with the specified data.
	 * @param obj the element that will become a part of the new tree node
	 */
	public Node(T obj) {
		element = obj;
		left = null;
		right = null;
	}

	public Node(T obj, Node left, Node right) {
		element = obj;
		this.left = left;
		this.right = right;
	}

	/**
	 * Return the element at this node.
	 * @return the element stored at this node
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Return the right child of this node.
	 * @return the right child of this node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Sets the right child of this node.
	 * @param node the right child of this node
	 */
	public void setRight(Node node) {
		right = node;
	}

	/**
	 * Return the left child of this node.
	 * @return the left child of the node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Sets the left child of this node.
	 * @param node the left child of this node
	 */
	public void setLeft(Node node) {
		left = node;
	}

	public String toString() {
		return "<NODE: " + element + ", " + (left != null) + ", " + (right != null) + ">";
		}
}

	protected Node root;
	protected int size = 0;

	/**
	 * Returns a reference to the root element
	 * @return a reference to the root
	 */
	public T getRootElement() {
		T result = null;
		if (root != null) {
			result = root.getElement();
		}
		return result;
	}

	/**
	 * Returns true if this binary tree is empty and false otherwise. 
	 * @return true if this binary tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0 || root == null;
	}

	/**
	 * Returns the number of elements in this binary tree.
	 * @return the number of elements in the tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if the binary tree contains an element that matches
	 * the specified element and false otherwise.
	 * @param targetElement the element being sought in the tree
	 * @return true if the tree contains the target element
	 */
	public abstract boolean contains(T targetElement);

	/**
	 * Returns a reference to the specified element if it is found in
	 * this binary tree. Throws an exception if the specified element
	 * is not found.
	 * @param targetElement the element being sought in the tree
	 * @return a reference to the specified element
	 */
	protected Node findNode(T targetElement) {
		return findNode(root, targetElement);
	}

	protected Node findNode(Node node, T targetElement) {
		if (node == null) {
			return null;
		}
		int compare = targetElement.compareTo(node.getElement());
		if (compare == 0) {
			return node;
		}
		if (compare < 0) {
			return findNode(node.getLeft(), targetElement);
		}
		return findNode(node.getRight(), targetElement);
	}

	/**
	 * Returns the string representation of this binary tree.
	 * @return a string representation of the binary tree
	 */
	public String toString() {
		String result = "[ ";
		for (T element : this) {
			result += element + " ";
		}
		return result + "]";
	}

	/** Returns the elements of the tree in a list
	 * @return 
	 */
	protected ArrayList<T> toList() {
		return toList(root, new ArrayList<T>());
	}

	protected ArrayList<T> toList(Node node, ArrayList<T> list) {
		if (node != null) {
			toList(node.getLeft(), list);
			list.add(node.getElement());
			toList(node.getRight(), list);
		}
		return list;
	}

	/**
	 * Returns an iterator over the elements of this tree.
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iterator() {
		return toList().iterator();
	}

	/**
	 * Returns an iterator that represents an inorder traversal on this binary tree.
	 * @return an iterator over the elements of this binary tree
	 */
	public abstract Iterator<T> iteratorInOrder();

	/**
	 * Returns an iterator that represents a preorder traversal on this binary tree.
	 * @return an iterator over the elements of this binary tree
	 */
	public abstract Iterator<T> iteratorPreOrder();

	/**
	 * Returns an iterator that represents a postorder traversal on this binary tree.
	 * @return an iterator over the elements of this binary tree
	 */
	public abstract Iterator<T> iteratorPostOrder();

	/**
	 * Adds the specified element to the proper location in this tree.
	 * @param element the element to be added to this tree
	 */
	public void addElement(T element) {
		if (root == null) {
			root = new Node(element);
			size++;
		} else {
			addElement(root, element);
		}
	}

	public void addElement(Node node, T element) {
		if (node == null) {
			return; // Should never happen
		} 
		int compare = element.compareTo(node.getElement( ) );
			
		if ( compare == 0 ) { 
			return;
		}
		if( compare < 0 ) { 
			if ( node.getLeft( ) != null ) {
				addElement( node.getLeft( ), element );
			} else {
				node.setLeft( new Node( element ) );
			} return;
		}
		if (compare > 0 ) { 
			if ( node.getRight( ) != null ) {
			addElement(node.getRight(), element);
		} else {
			node.setRight(new Node(element));
		}
		return;
		}
	}

	/**
	 * Removes and returns the specified element from this tree.
	 * @param targetElement the element to be removed from the tree
	 * @return the element to be removed from the tree
	 */
	public abstract T removeElement(T targetElement);

	/**
	 * Returns the node with the smallest element in the subtree rooted at the given node.
	 * @return the node with the smallest element in the subtree
	 */
	protected Node getMinNode(Node node) {
		if (node == null) {
			return null;
		}
		if (node.getLeft() == null) {
			return node;
		}
		return getMinNode(node.getLeft());
	}

	/**
	 * Returns the node with the largest element in the subtree rooted at the given node.
	 * @return the node with the largest element in the subtree
	 */
	protected abstract Node getMaxNode( Node node );
	
}