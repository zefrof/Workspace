import java.util.ArrayList;

/**
 * --------------------------------------------------------------------------
 * CLASS:  AbstractArrayHeap<K,V>
 * @author ureel
 * @see HeapAPI
 * @see HeapEntry
 * DESCRIPTION:
 * An Array-based implementation of Heap.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public abstract class AbstractArrayHeap<K extends Comparable<K>, V> implements HeapAPI<K, V> {
   
   public AbstractArrayHeap( int capacity ) {
      heapArray = new ArrayList<HeapEntryAPI<K,V>>( capacity );
   }
   
   /**
    * --------------------------------------------------------------------------
    * DATA MEMBER & ACCESSORS:  heapArray
    * @author ureel
    * DESCRIPTION: The Heap array implemented using an ArrayList.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected ArrayList<HeapEntryAPI<K, V>> heapArray = null;

   /**
    * --------------------------------------------------------------------------
    * DATA MEMBER & ACCESSORS: nextEntryIndex
    * @author ureel
    * DESCRIPTION: Points to the next available entry slot in the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   private int nextEntryIndex = 0;
   protected int getNextEntryIndex( ) {
      return nextEntryIndex;
   }
   protected void setNextEntryIndex( int value ) {
      nextEntryIndex = value;
   }
   protected int incrementNextEntryIndex(  ) {
      return ( ++nextEntryIndex );
   }
   protected int decrementNextEntryIndex(  ) {
      return( --nextEntryIndex );
   }  

   @Override
   public int size() {
      if ( heapArray == null) {
         return 0;
      }
      return ( getNextEntryIndex( ) );
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: putEntryAt( HeapEntryAPI<K, V> entry, int index )
    * @author ureel
    * DESCRIPTION:
    * Stores the entry at the specified index in the heap array.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected HeapEntryAPI<K, V> putEntryAt( HeapEntryAPI<K, V> entry, int index ) {
      if ( index < heapArray.size( ) ) {
         heapArray.set( index, entry );
      } else {
         heapArray.add( index, entry );
      }
      return entry;
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: isEmpty()
    * @author ureel
    * DESCRIPTION:
    * Returns true if there are no entries in the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   @Override
   public boolean isEmpty() {
      return ( size( ) == 0 );
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: min()
    * @author ureel
    * DESCRIPTION:
    * Returns but does not remove an entry with minimum key
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   @Override
   public EntryAPI<K, V> min() throws EmptyPriorityQueueException {
      if ( isEmpty( ) ) {
         throw new EmptyPriorityQueueException( "ArrayHeap.min( ) reports empty heap." );
      }
      return heapArray.get( 0 );
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: insert(K key, V value)
    * @author ureel
    * DESCRIPTION:
    * Inserts an entry with key and value into the heap and returns that entry.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   @Override
   public EntryAPI<K, V> insert(K key, V value) throws InvalidKeyException {
      if ( key == null ) {
         throw new InvalidKeyException( );
      }
      HeapEntryAPI<K, V> newEntry= new HeapEntry<K, V>( key, value);
      return insert( newEntry );
   }
   
   /**
    * --------------------------------------------------------------------------
    * METHODS: insert(HeapEntryAPI<K, V> newEntry)
    * @author ureel
    * DESCRIPTION:
    * Inserts an entry into the heap and returns that entry.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public EntryAPI<K, V> insert(HeapEntryAPI<K, V> newEntry) throws InvalidKeyException {
      putEntryAt( newEntry, getNextEntryIndex( ) );
      upHeap( getNextEntryIndex( ) );
      incrementNextEntryIndex( );
      return newEntry;
   }
   
   /**
    * --------------------------------------------------------------------------
    * METHODS: removeMin()
    * @author ureel
    * DESCRIPTION:
    * Removes and returns an entry with minimum key.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   @Override
   public EntryAPI<K, V> removeMin() throws EmptyPriorityQueueException {
      if ( isEmpty( ) ) {
         throw new EmptyPriorityQueueException( "removeMin: EMPTY HEAP" );
      }
      HeapEntryAPI<K, V> result = heapArray.get( 0 );
      decrementNextEntryIndex( );
      heapArray.set( 0, heapArray.remove( getNextEntryIndex( ) ) );
      downHeap( 0 );
      return result;
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: remove( K key)
    * @author ureel
    * DESCRIPTION:
    * Removes and returns an entry from the Heap then fixes the heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public abstract EntryAPI<K, V> remove( K key) throws EmptyPriorityQueueException;

   /**
    * --------------------------------------------------------------------------
    * METHODS: isEven( int i )
    * @author ureel
    * DESCRIPTION:
    * Returns true if i is even.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected boolean isEven ( int i ) {
      return ( i % 2 == 0 );
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: isOdd( int i )
    * @author ureel
    * DESCRIPTION:
    * Returns true if i is odd.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected boolean isOdd ( int i ) {
      // It is important to implement isOdd( ) like this. Why?
      return !isEven( i );
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: upHeap( int i )
    * @author ureel
    * DESCRIPTION:
    * Bubbles the indexed entry up the Heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected void upHeap( int i ) {
      if ( i > 0 ) {
         int p = isEven( i ) ? ( i - 2 ) / 2 : ( i - 1 ) / 2;
         HeapEntryAPI<K, V> pA = heapArray.get( p );
         HeapEntryAPI<K, V> iA = heapArray.get( i );
         if ( iA.compareTo( pA ) < 0 ) {
            heapArray.set( p, iA );
            heapArray.set( i, pA );
            upHeap( p );
         }
      }
   }

   /**
    * --------------------------------------------------------------------------
    * METHODS: downHeap( int indexOfEntry )
    * @author ureel
    * DESCRIPTION:
    * Bubbles the indexed entry down the Heap.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   protected abstract void downHeap( int indexOfEntry );

   /**
    * --------------------------------------------------------------------------
    * METHODS: toString( )
    * @author ureel
    * DESCRIPTION:
    * Represents the heap as a human readable string.
    * --------------------------------------------------------------------------
    * MODIFICATIONS:
    *   2013/09/15 UREEL: Created
    * --------------------------------------------------------------------------
    */
   public String toString( ) {
      return "<Heap: " + heapArray + ">";
   }
}
