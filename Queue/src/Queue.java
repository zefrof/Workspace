public class Queue<V> {
	
	public class Node {
		MusicTrack value = null;
		public MusicTrack getValue( ) { return value; }
		public void setValue( MusicTrack musicTrack ) { value = musicTrack; }
		
		Node next = null;
		public Node getNext( ) { return next; }
		public void setNext( Node n ) { next = n; }
		
		public Node( MusicTrack musicTrack ) { setValue( musicTrack ); }
	}
	
	Node first = null;
	Node last = null;
	int size = 0;

	public MusicTrack deque( ) throws DequeOnEmptyQueueException {
		if ( isEmpty( ) ) {
			throw new DequeOnEmptyQueueException( );
		}
		MusicTrack result = first.getValue();
		if ( size == 1 ) {
			last = null;
			first = null;
		} else {
			Node cur = last;
			while( cur.getNext() != first ) {
				cur = cur.getNext();
			}
			first = cur;
			cur.setNext( null );
		}
		size--;
		return result;
	}
	
	public void enque( MusicTrack musicTrack ) {
		Node node = new Node( musicTrack );
		node.setNext( last );
		last = node;
		if ( isEmpty( ) ) {
			first = node;
		}
		size++;
	}
	
	public MusicTrack peek( ) throws PeekOnEmptyQueueException {
		if ( isEmpty( ) ) {
			throw new PeekOnEmptyQueueException( );
		}
		return first.getValue();
	}
	
	public int size( ) {
		if ( first == null ) {
			return 0;
		}
		return size;
	}
	
	public boolean isEmpty( ) {
		return ( (size == 0) || (first == null) );
	}
	
	
	
	
	
}