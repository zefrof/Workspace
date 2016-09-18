/**
 * --------------------------------------------------------------------------
 * CLASS:  ArrayHeap<K,V>
 * @author ureel
 * @see AbstractArrayHeap
 * @see HeapEntry
 * DESCRIPTION:
 * An Array-based implementation of Heap.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class ArrayHeap<K extends Comparable<K>, V> extends AbstractArrayHeap<K,V> {
   
   /**
    * --------------------------------------------------------------------------
    * Constructor:  ArrayHeap( int capacity )
    * @author ureel
    * DESCRIPTION: Initialize the Heap array.
    * @param capacity - the initial capacity of the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public ArrayHeap( int capacity ) {
      super( capacity );
   }
   
   /**
    * --------------------------------------------------------------------------
    * METHODS: remove( K key)
    * @author ureel
    * DESCRIPTION:
    * Removes and returns an entry from the Heap then fixes the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public EntryAPI<K, V> remove(K key) throws EmptyPriorityQueueException {
	   if (isEmpty())
		   throw new EmptyPriorityQueueException("Heap is empty");
	   else {
		  return heapArray.remove(key);
	   }
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: downHeap( int indexOfEntry )
    * @author ureel
    * DESCRIPTION:
    * Bubbles the indexed entry down the Heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected void downHeap( int indexOfEntry ) {
      // Your Code Here
   }
}
