/** Interface for the priority queue ADT */
public interface PriorityQueueAPI<K extends Comparable<K>,V> {
  /** Returns the number of items in the priority queue. */
  public int size();
  /** Returns whether the priority queue is empty. */
  public boolean isEmpty();
  /** Returns but does not remove an entry with minimum key. */
  public EntryAPI<K,V> min() throws EmptyPriorityQueueException;
  /** Inserts a key-value pair and return the entry created. */
  public EntryAPI<K,V> insert(K key, V value) throws InvalidKeyException;
  /** Removes and returns an entry with minimum key. */
  public EntryAPI<K,V> removeMin() throws EmptyPriorityQueueException;
}
