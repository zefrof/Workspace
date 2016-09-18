/** Interface for a key-value pair entry **/
public interface EntryAPI<K extends Comparable<K>,V> extends Comparable<EntryAPI<K,V>> {
  /** Returns the key stored in this entry. */
  public K getKey();
  /** Returns the value stored in this entry. */
  public V getValue();
}
