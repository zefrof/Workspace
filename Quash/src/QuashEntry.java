public class QuashEntry<K extends Comparable<K>, V> implements HeapEntryAPI<K,V>, HashEntryAPI<K,V>, Comparable<EntryAPI<K,V>> {
   public QuashEntry( K k, V v ) {
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
   K key = null;
   public K getKey() {
      return key;
   }
   public void setKey( K k ) {
      key = k;
   }

   /**
    * --------------------------------------------------------------------------
    * DATA MEMBER & ACCESSORS:  bucket
    * @author ureel
    * DESCRIPTION:
    * The bucket used to store the value in a Hash Table.
    * Calculated based on the Key.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   int bucket = -1;
   public int getBucket( ) { 
      return bucket; 
      }
   public void setBucket( int b ) { 
      bucket = b; 
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
   public V getValue() {
      return value;
   }
   public void setValue( V v ) {
      value = v;
   }
   
   /**
    * --------------------------------------------------------------------------
    * METHODS:  compareTo
    * @author ureel
    * DESCRIPTION:
    * Compares this QuashEntry Key to that of another.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public int compareTo(EntryAPI<K,V> quashEntry) {
      // Cast result of getKey to be of type Comparable.
       return getKey( ).compareTo( quashEntry.getKey( ) );
   }

   public String toString( ) {
      return String.format( "<QuashEntry: key=%s bucket=%s value=%s>", getKey( ), getBucket( ), getValue( ) );
   }

}
