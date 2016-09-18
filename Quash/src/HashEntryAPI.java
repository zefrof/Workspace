public interface HashEntryAPI<K extends Comparable<K>,V> extends EntryAPI<K,V>, Comparable<EntryAPI<K,V>> {

   /** Returns the key stored in this entry. */
   public K getKey();
   /** Sets the key stored in this entry. */
   public void setKey( K k );

   /** Returns the value stored in this entry. */
   public V getValue();
   /** Sets the value stored in this entry. */
   public void setValue( V v );

   /** Returns the bucket number associated with this entry. */
   public int getBucket( );
   /** Sets the bucket number associated with this entry. */
   public void setBucket( int v );

}
