public abstract class QuashAPI<K,V> {

   /** Number of entries in the Quash */
   public abstract int size();

   /** True if there are no entries in the Quash */
   public abstract boolean isEmpty();

   /** Returns the value of the minimum entry in the Quash */
   public abstract V min() throws EmptyPriorityQueueException;

   /** Removes the minimum entry in the Quash returning its value */
   public abstract V removeMin() throws EmptyPriorityQueueException;

   /** Puts a given value in the Quash. */
   public abstract V put(K key, V value) throws InvalidKeyException;

   /** Given a key, retrieves the associated value from the Quash. */
   public abstract V get(K key) throws InvalidKeyException;

   /** Removes the entry identified by key from the Quash. */
   public abstract V remove(K key) throws InvalidKeyException;

   /** Prints, on two separate lines, the Heap and the HashTable from the Quash. */
   public abstract void print();

}
