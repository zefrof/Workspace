/**
 * --------------------------------------------------------------------------
 * CLASS: HeapEntryAPI<K extends Comparable<K>,V>
 * @author ureel
 * @see EntryAPI
 * @see Comparable
 * DESCRIPTION:
 * Entry in an Heap. Contains a value and a key.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public interface HeapEntryAPI<K extends Comparable<K>,V> extends EntryAPI<K,V>, Comparable<EntryAPI<K,V>> {

}
