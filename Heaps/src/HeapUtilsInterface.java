public interface HeapUtilsInterface<V extends Comparable<V>> {
	/**
	 * Given the index of a parent, returns the index of the left child.
	 * Assumes an array-based implementation of a binary tree.
	 * Does not check to see if the child index is out of bounds.  
	 * @param parentIndex
	 * @return
	 */
	public int getIndexOfLeftChild(int parentIndex);

	/**
	 * Given the index of a parent, returns the index of the right child.
	 * Assumes an array-based implementation of a binary tree.
	 * Does not check to see if the child index is out of bounds.
	 * @param parentIndex
	 * @return
	 */
	public int getIndexOfRightChild(int parentIndex);

	/**
	 * Given the index of a child, returns the index of the parent.
	 * Assumes an array-based implementation of a binary tree.
	 * Does not check to see if the parent index is out of bounds.
	 * @param childIndex
	 * @return
	 */
	public int getParentIndex(int childIndex);

	/**
	 * Bubble a value up the heap.
	 * @param data - an array that constitutes a valid heap
	 * @param index - index of the array value that is being up-heap bubbled.
	 */
	public void bubbleUp(V[] data, int index);

	/**
	 * BubbleDown the heap. Bubbles the value at index down the heap,
	 * stopping at the stop index.
	 * @param data - an array that constitutes a valid heap
	 * @param index - index of the array value that is being up-heap bubbled.
	 * @param partitionBoundaryIndex - index of the first array element in the
	 * non-heap, sorted partition of the array.
	 */
	public void bubbleDown(V[] data, int index, int partitionBoundaryIndex);

	/**
	 * Destructive In-Place Heap Sort. The sort method makes use of the fact that
	 * a max-oriented heap's root is always the max element of the queue. To sort
	 * the array in place, we must partition the array into heap and sorted parts.
	 * @param data - an array that constitutes a valid heap
	 */
	public void InplaceHeapSort(V[] data);
}