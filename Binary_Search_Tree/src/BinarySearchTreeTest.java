import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testConstructor() {
		BinarySearchTree<?> testObj = new BinarySearchTree();	
		if(!(testObj instanceof BinarySearchTree)){
			fail("constructor returned object of wrong type");
		}
	}
	
	@Test
	public void testIteratorInOrder() {
		BinarySearchTree<Integer> testObj = new BinarySearchTree<Integer>();	
		testObj.addElement(5);
		testObj.addElement(3);
		testObj.addElement(7);
		testObj.addElement(6);
		testObj.addElement(8);
		testObj.addElement(2);
		testObj.addElement(4);
		ArrayList<Integer> compare = new ArrayList<Integer>();
		compare.add(2);
		compare.add(3);
		compare.add(4);
		compare.add(5);
		compare.add(7);
		compare.add(6);
		compare.add(8);
			
		if(!testObj.iteratorInOrder().equals(compare.listIterator())){
			fail("iteratorInOrder returned an interator in the wrong order");
		}
	}
	
	@Test
	public void testIteratorPreOrder() {
		BinarySearchTree<Integer> testObj = new BinarySearchTree<Integer>();	
		testObj.addElement(5);
		testObj.addElement(3);
		testObj.addElement(7);
		testObj.addElement(6);
		testObj.addElement(8);
		testObj.addElement(2);
		testObj.addElement(4);
		ArrayList<Integer> compare = new ArrayList<Integer>();
		compare.add(2);
		compare.add(3);
		compare.add(4);
		compare.add(5);
		compare.add(7);
		compare.add(6);
		compare.add(8);
			
		if(!testObj.iteratorPreOrder().equals(compare.listIterator())){
			fail("iteratorPreOrder returned an interator in the wrong order");
		}
	}
	
	@Test
	public void testIteratorPostOrder() {
		BinarySearchTree<Integer> testObj = new BinarySearchTree<Integer>();	
		testObj.addElement(5);
		testObj.addElement(3);
		testObj.addElement(7);
		testObj.addElement(6);
		testObj.addElement(8);
		testObj.addElement(2);
		testObj.addElement(4);
		ArrayList<Integer> compare = new ArrayList<Integer>();
		compare.add(2);
		compare.add(3);
		compare.add(4);
		compare.add(5);
		compare.add(7);
		compare.add(6);
		compare.add(8);
			
		if(!testObj.iteratorPostOrder().equals(compare.listIterator())){
			fail("iteratorPostOrder returned an interator in the wrong order");
		}
	}
	
	@Test
	public void testRemoveElement() {
		
	}
	
	@Test
	public void testGetMaxNode() {
		BinarySearchTree<Integer> testObj = new BinarySearchTree<Integer>();
		testObj.addElement(10);
		if(testObj.getMaxNode(testObj.first).getElement() != 10){
			fail("getMaxNode returned the wrong node");
		}
		
		testObj.addElement(5);
		testObj.addElement(15);
		if(testObj.getMaxNode(testObj.first).getElement() != 15){
			fail("getMaxNode returned the wrong node");
		}
	}
	
	@Test
	public void testContains() {
		BinarySearchTree<Integer> testObj = new BinarySearchTree<Integer>();
		testObj.addElement(6);
		testObj.addElement(7);
		testObj.addElement(3);
		
		if(!testObj.contains(6)) {
			fail("returned false when it should've returned true");
		}
		
		if(testObj.contains(8)) {
			fail("returned true when it should've returned false");
		}
	}

}
