/**
 * 
 * @author Darren Wiltse
 * @author Nicholas Thomas
 * @author Alex Stanage
 *
 * @param <V>
 */

public class Stack<V> {
	
	private Node top = null;
	private int size = 0;
	
	private class Node {
		V value = null;
		public V getValue( ) { return value; }
		Node next = null;
		public Node getNext( ) { return next; }
		public void setNext( Node next ) { this.next = next; }
		
		public Node( V value ) { this.value = value; }
	}
	
	public void push( V value ) {
		Node current = top;
		top = new Node( value );
		if ( current != null ) {
			top.setNext( current );
		}
		size++;
	}
	
	public V pop( ) {
		Node current = top;
		if ( current != null ) {
			top = current.getNext( );
			size--;
			return current.getValue( );
		}
		return null;
	}
	
	public V peek( ) {
		V result = null;
		if ( top != null ) {
			result = top.getValue( );
		}
		return result;
	}
	
	public int size( ) {
		return this.size;
	}
	
	public boolean empty( ) {
		return ( top == null ) || ( size == 0 );
	}
	
	public boolean balancedParens(String s){
		Stack quux = new Stack();
		char[] foo = s.toCharArray();
		for(char c : foo){
			if(c == 40){
				quux.push(c);
			} else if(c == 41){
				quux.pop();
			}
		}
		if(quux.peek() != null){
			return false;
		} else{
			return true;
		}
	}
	
	public boolean equalNumberAsAndBs(){
		if(size%2 == 0){
			for(int i = 0; i < size/2; i++){
				if(this.peek().equals("B")){
					return false;
				} else if(this.peek().equals("A")){
					this.pop();
				}
			}
			if(this.peek().equals("A")){
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String source = "FOOBAR";
		char [ ] chars =  source.toCharArray(  );
		Stack<Character> stack = new Stack<Character>( );
		for( char c: chars ) {
			stack.push( c );
		}
		String reversed = source;
		while ( !stack.empty( ) ) {
			reversed += stack.pop( );
		}
		System.out.println( reversed );

	}

}