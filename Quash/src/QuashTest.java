public class QuashTest {
	public static void main (String[] argv) {
		// Sample test code		
		Quash<Integer, String> myQuash = new Quash<Integer, String>( 10 );
		myQuash.print( );
		myQuash.put( 10 , "Ted" );
      myQuash.print( );
		myQuash. put( -50, "Alice"  );
      myQuash.print( );
		myQuash. put( 76, "Bob" );
      myQuash.print( );
		myQuash. get( 12 );
      myQuash.print( );
		myQuash. put( 12, "Carol" );
      myQuash.print( );
		myQuash. get( 12 );
      myQuash.print( );
		myQuash. removeMin( );
      myQuash.print( );
		myQuash. remove( 76 );
      myQuash.print( );
		myQuash. put( 12, "Carol" );
      myQuash.print( );
		myQuash. removeMin( );
      myQuash.print( );
		myQuash. get( 76 );
      myQuash.print( );
	}
}
