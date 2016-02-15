import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***
 * 
 * @author Darren Wiltse
 * 
 * CS1122
 * @param <T>
 *
 */
public class Queue<T> implements QueueInterface<T> {
	
	public class Node {
		T value = null;
		public T getValue( ) { return value; }
		public void setValue( T t ) { value = t; }
		
		Node next = null;
		public Node getNext( ) { return next; }
		public void setNext( Node n ) { next = n; }
		
		public Node( T t ) { setValue( t ); }
	}
	
	Node first = null;
	Node last = null;
	int size = 0;
	int maxSize;
	
	public Queue( int sizeLimit ){
		maxSize = sizeLimit;
	}
	
	@Override
	public void enqueue(T element) throws QueueFullException {
		if(size != maxSize){
			Node node = new Node( element );
			node.setNext( last );
			last = node;
			if ( isEmpty( ) ) {
				first = node;
			}
			size++;
		} else {
			throw new QueueFullException();
		}
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		if ( isEmpty( ) ) {
			throw new QueueEmptyException( );
		}
		T result = first.getValue();
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

	@Override
	public T peek() throws QueueEmptyException {
		if ( isEmpty( ) ) {
			throw new QueueEmptyException( );
		}
		return first.getValue();
	}

	@Override
	public boolean isEmpty() {
		return ( (size == 0) || (first == null) );
	}

	@Override
	public boolean isFull() {
		if(size == maxSize){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		if ( first == null ) {
			return 0;
		}
		return size;
	}
	
	public String toString() {
		if(isEmpty()){
			return "[]";
		} else {
			String[] temp = new String[size];
			Node cur = last;
			for(int i = 0; i < size; i++){
				temp[i] = cur.getValue().toString();
				cur = cur.getNext();
			}
			String str = "[";
			for(int i = 0; i < size - 1; i++){
				 str = str + temp[i] + ", ";
			}
			return str + temp[size - 1] +  "]";
		}
	}
}
