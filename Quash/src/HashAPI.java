public interface HashAPI<K extends Comparable<K>,V> {

   /** return the number of nodes in the hash table */
   public int size();

   /** return true of there are no nodes in the hash table */
   public boolean isEmpty();

   /** add the value to the hashTable */
   public V put(K key, V value) throws InvalidKeyException;

   /** add the hashEntry to the hashTable */
   public V put(HashEntryAPI<K,V> entry) throws InvalidKeyException;

   /** return the value if an entry with key is found in the hash table */
   public V get(K key) throws InvalidKeyException;

   /** remove the entry with key and return the value */
   public V remove(K key) throws InvalidKeyException;

   /** convert the key to an integer using the hash function, e.g. abs(key) mod 43 */
   public int hashFn( K key );
}
