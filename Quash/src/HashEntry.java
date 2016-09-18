/**
 * --------------------------------------------------------------------------
 * CLASS:  HashEntry<K,V>
 * @author ureel
 * @see Entry
 * @see HashTable
 * @see Comparable
 * DESCRIPTION:
 * Entry in an HashTable. Contains a value and a key and a bucket index.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class HashEntry<K extends Comparable<K>,V> implements HashEntryAPI<K,V>, EntryAPI<K,V>, Comparable<EntryAPI<K,V>> {
   public HashEntry( K k, V v) {
      setKey( k );
      setValue( v );
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
   private K key = null;
   @Override
   public K getKey() {
      return key;
   }
   public void setKey( K k ) {
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
   private V value = null;
   @Override
   public V getValue() {
      return value;
   }
   public void setValue( V v ) {
      value = v;
   }
   
   /**
    * --------------------------------------------------------------------------
    * DATA MEMBER & ACCESSORS:  bucket
    * @author ureel
    * DESCRIPTION:
    * The index of the entry in a HashTable bucket array.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   private int bucket = -1;
   @Override
   public int getBucket( ) {
      return bucket;
   }
   @Override
   public void setBucket( int b ) {
     bucket = b;
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
      return "<HashEntry: key="+getKey( ) + " value=" + getValue( ) + " bucket=" + getBucket( ) + ">";
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
   
   public int compareTo(HashEntry<K,V> b) {
      if ( b == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare HashEntry to null."); 
      }
      if ( b.getKey( ) == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare HashEntry to Entry with null key."); 
      }
      if ( getKey( ) == null ) { 
         throw new NullPointerException("NullPointerException: Cannnot compare HashEntry with null key."); 
      }
       return getKey( ).compareTo(b.getKey( ));
   }

}
