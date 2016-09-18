/** 
  * Realization of a priority queue by means of a heap.  A complete
  * binary tree realized by means of an array list is used to
  * represent the heap.
  *
  * @author Roberto Tamassia, Michael Goodrich, Eric Zamore
  */
public interface HeapAPI<K extends Comparable<K>,V> extends PriorityQueueAPI<K,V> {
  /** Returns the size of the heap */
  public int size();
  
  /** Returns whether the heap is empty */
  public boolean isEmpty();
  
  /** Returns but does not remove an entry with minimum key */
  public EntryAPI<K,V> min() throws EmptyPriorityQueueException;
  
  /** Inserts a key-value pair and returns the entry created */
  public EntryAPI<K,V> insert(K k, V x) throws InvalidKeyException;
 
  /** Removes and returns an entry with minimum key */
  public EntryAPI<K,V> removeMin() throws EmptyPriorityQueueException;
  
  /** Text visualization for debugging purposes */
  public String toString();
}
