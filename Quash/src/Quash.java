/**
 * --------------------------------------------------------------------------
 * CLASS: Quash<K extends Comparable<K>,V>
 * @author ureel
 * @see QuashAPI
 * DESCRIPTION:
 * Implements a Quash, which has the properties of both a Heap and a HashTable.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class Quash<K extends Comparable<K>,V> extends QuashAPI<K,V> {
   
   ArrayHeap<K,V> heap = null;
   HashTable<K,V> hash = null;
   
   public Quash( int capacity ) {
      heap = new ArrayHeap<K,V>( capacity );
      hash = new HashTable<K,V>( capacity );
   }

   /** Number of entries in the Quash */
   @Override
   public int size( ) {
      // TODO Auto-generated method stub
      return 0;
   }

   /** True if there are no entries in the Quash */
   @Override
   public boolean isEmpty( ) {
      // TODO Auto-generated method stub
      return false;
   }

   /** Returns the value of the minimum entry in the Quash */
   @Override
   public V min( ) throws EmptyPriorityQueueException {
      // TODO Auto-generated method stub
      return null;
   }

   /** Removes the minimum entry in the Quash returning its value */
   @Override
   public V removeMin( ) throws EmptyPriorityQueueException {
      // TODO Auto-generated method stub
      return null;
   }

   /** Puts a given value in the Quash. */
   @Override
   public V put( K key, V value ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** Given a key, retrieves the associated value from the Quash. */
   @Override
   public V get( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** Removes the entry identified by key from the Quash. */
   @Override
   public V remove( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** Prints, on two separate lines, the Heap and the HashTable from the Quash. */
   @Override
   public void print( ) {
      // TODO Auto-generated method stub
      
   }

   /**
    * Represents the Quash as a human readable string.
    * @return 
    */
   @Override
   public String toString( ) {
      return "<Quash:\n   heap:" +  heap + "\n   hash:" + hash + ">";
   }
}
