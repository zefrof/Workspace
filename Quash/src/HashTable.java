
import java.util.ArrayList;

/**
 * --------------------------------------------------------------------------
 * CLASS:  HashTable<K,V>
 * @author ureel
 * @see HashAPI
 * @see HashEntry
 * DESCRIPTION:
 * An implementation of Hash Table.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class HashTable<K extends Comparable<K>, V> implements HashAPI<K, V> {
   
   /**
    * --------------------------------------------------------------------------
    * Constructor:  HashTable( int capacity )
    * @author ureel
    * DESCRIPTION: Initialize the HashTable.
    * @param capacity - the capacity of the Hash Table (number of buckets.)
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public HashTable( int capacity ) {
      // Your Code Here
   }

   /** return the number of nodes in the hash table */
   @Override
   public int size( ) {
      // TODO Auto-generated method stub
      return 0;
   }

   /** return true of there are no nodes in the hash table */
   @Override
   public boolean isEmpty( ) {
      // TODO Auto-generated method stub
      return false;
   }

   /** add the value to the hashTable */
   @Override
   public V put( K key, V value ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** add the hashEntry to the hashTable */
   @Override
   public V put( HashEntryAPI< K, V > entry ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** return the value if an entry with key is found in the hash table */
   @Override
   public V get( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** remove the entry with key and return the value */
   @Override
   public V remove( K key ) throws InvalidKeyException {
      // TODO Auto-generated method stub
      return null;
   }

   /** convert the key to an integer using the hash function, e.g. abs(key) mod 43 */
   @Override
   public int hashFn(K key) {
      // Something like:
      // return( Math.abs( key.hashCode( ) ) % buckets.size( ) );
      return 0;
   }

   /** Represent the HashTable as a string. */
   public String toString( ) {
      // Something like:
      // return "<HashTable: " + buckets + ">";
      return null;
   }

}
