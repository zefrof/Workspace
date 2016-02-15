import java.util.ArrayList;


public class Tree<V extends Comparable> {
	private class TreeNode {
		V value = null;
		//TreeNode parent = null;
		TreeNode leftChild = null;
		TreeNode rightChild = null;
		
		public TreeNode(V newVal){
			value = newVal;
		}
		
		boolean isLeaf(){
			return (leftChild == null && rightChild == null);
		}
		boolean isParent(){
			return (leftChild != null || rightChild != null);
		}
	}
	
	private TreeNode root = null;
	public TreeNode getRoot(){
		return root;
	}
	
	public TreeNode getLeftChild(TreeNode parent){
		return parent.leftChild;
	}
	
	public TreeNode getRightChild(TreeNode parent){
		return parent.rightChild;
	}
	
	public Boolean isLeaf(TreeNode node){
		return node.isLeaf();
	}
	
	public Boolean isRoot(TreeNode node){
		return node == root;
	}
	
	public Boolean isParent(TreeNode node){
		return node.isParent();
	}
	
	public void add(V value){
		TreeNode node = new TreeNode(value);
		if(root == null){
			root = node;
		}
		TreeNode current = root;
		while(true){
			int compare = current.value.compareTo(value);
			if(compare > 0){
				if(current.rightChild == null){
					current.rightChild = node;
					break;
				} else {
					current = current.rightChild; 
				} 
			} else {
				if(current.leftChild == null){
					current.leftChild = node;
					break;
				} else {
					current = current.leftChild;
				}
			}
		}
	}
	
/*	public ArrayList<TreeNode> makeTreeArray(TreeNode parent, ArrayList<TreeNode> levels){
		levels.add(parent);
		levels.ensureCapacity(2 * (index + 1));
		int end = levels.size();
		for(int i = end; i < index; i++) {levels.add(null);}
		levels.set(index, newvalue);
	} */
	
	public void printTree(TreeNode node){
		if(node == null){
			System.out.print(null + " ");
			return;
		}
		System.out.print(node.value + " ");
		printTree(node.leftChild);
		printTree(node.rightChild);
	}

	public static void main(String[] args) {
		Tree<Integer> self = new Tree<Integer>();
		self.add(9);
		self.add(2);
		self.add(5);
		self.add(4);
		self.add(1);
		self.add(6);
		self.add(12);
		self.add(10);
		self.add(8);
		
		self.printTree(self.root);
	}

}
