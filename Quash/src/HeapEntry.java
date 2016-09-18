/**
 * --------------------------------------------------------------------------
 * CLASS:  HeapEntry<K,V>
 * @author ureel
 * @see Entry
 * @see ArrayHeap
 * @see Comparable
 * DESCRIPTION:
 * Entry in an ArrayHeap. Contains a value and a key.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class HeapEntry<K extends Comparable<K>,V> implements HeapEntryAPI<K,V>, EntryAPI<K,V>, Comparable<EntryAPI<K,V>> {
   public HeapEntry ( ) {
      
   }
   
   /**
    * --------------------------------------------------------------------------
    * DATA MEMBER & ACCESSORS:  key
    * @author ureel
    * DESCRIPTION:
    * The key used to sort the value in a Heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   K key = null;
   @Override
   public K getKey() {
      return key;
   }
   private void setKey( K k ) {
      key = k;
   }

   /**
    * --------------------------------------------------------------------------
    * DATA MEMBER & ACCESSORS:  value
    * @author ureel
    * DESCRIPTION:
    * The value of the entry in a Heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   V value = null;
   @Override
   public V getValue() {
      return value;
   }
   private void setValue( V v ) {
      value = v;
   }
   
   public HeapEntry( K k, V v) {
      setKey( k );
      setValue( v );
   }
   
   /**
    * --------------------------------------------------------------------------
    * METHODS:  toString
    * @author ureel
    * DESCRIPTION:
    * English friendly text description of the HeapEntry
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public String toString( ) {
      return "<HeapEntry: key="+getKey( )+" value=" + getValue( ) + ">";
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS:  compareTo
    * @author ureel
    * DESCRIPTION:
    * Compares this HeapEntry key to that of another.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   @Override
   public int compareTo(EntryAPI<K,V> b) {
      if ( b == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare Entry to null."); 
      }
      if ( b.getKey( ) == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare Entry to Entry with null key."); 
      }
      if ( getKey( ) == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare Entry with null key."); 
      }
       return getKey( ).compareTo(b.getKey( ));
   }
   
   public int compareTo(HeapEntry<K,V> b) {
      if ( b == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare HeapEntry to null."); 
      }
      if ( b.getKey( ) == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare HeapEntry to Entry with null key."); 
      }
      if ( getKey( ) == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare HeapEntry with null key."); 
      }
       return getKey( ).compareTo(b.getKey( ));
   }
   
}
