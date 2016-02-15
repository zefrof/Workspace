import static org.junit.Assert.*;
import org.junit.*;


public class RectTest {
	
	boolean [] error = new boolean [10]; 

	@Test
	public void testConstructor() {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			/*if(testObject == null){
				fail("constructor returned null");
			} */
		
			if(!(testObject instanceof Rect)){
				fail("constructor returned object of wrong type");
				error[0] = true;
			}
		
			if(testObject.getX() != x[offset] || testObject.getY() != y[offset] || 
					testObject.getWidth() != w[offset] || testObject.getHeight() != h[offset]){
				fail("constructor returned wrong rect");
				error[1] = true;
			}
		}	
	}
	
	@Test
	public void testContainsPointCorner() {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(!(testObject.contains(x[offset], y[offset]))){
				fail("contains method failed on input" + x[offset] + "," + y[offset] +  " for Rect" + testObject);
				error[2] = true;
			}
		}
	}
	
	@Test
	public void testContainsPointEdge() {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		int [] le = {20, -20, 0, -5, 7, 15};
		
		for(int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(!(testObject.contains(x[offset], le[offset]))){
				fail("contains method failed on input" + x[offset] + "," + y[offset] +  " for Rect" + testObject);
				error[9] = true;
			}
		}
	}
	
	@Test
	public void testContainsPointInside() {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		int [] inx = {45, -51, 0, 7, 7, 10};
		int [] iny = {20, -26, 0, -4, 7, 15};
		
		for(int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(!(testObject.contains(inx[offset], iny[offset]))){
				fail("contains method failed on input" + x[offset] + "," + y[offset] +  " for Rect" + testObject);
				error[10] = true;
			}
		}
	}
	
	@Test
	public void testgetX () {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(testObject.getX() != x[offset]){
				fail("getX returned: " + testObject.getX() + ", expected: " + x[offset]);
				error[3] = true;
			}
		}
	}
	
	@Test
	public void testgetY () {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < y.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(testObject.getY() != y[offset]){
				fail("getY returned: " + testObject.getY() + ", expected: " + y[offset]);
				error[4] = true;
			}
		}
	}
	
	@Test
	public void testgetWidth () {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < w.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(testObject.getWidth() != w[offset]){
				fail("getWidth returned: " + testObject.getWidth() + ", expected: " + w[offset]);
				error[5] = true;
			}
		}
	}
	
	@Test
	public void testgetHeight () {

		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < h.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(testObject.getHeight() != h[offset]){
				fail("getHeight returned: " + testObject.getHeight() + ", expected: " + h[offset]);
				error[6] = true;
			}
		}
	}

	@Test
	public void testContainsRect () {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		int [] tx = {10, -10, 0, 2, 6, 10};
		int [] ty = {10, -10, 0, -2, 6, 15};
		int [] tw = {20, -20, 0, 5, 2, 0};
		int [] th = {20, -20, 0, -5, 2, 5};
		
		for (int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(!(testObject.contains(new Rect(tx[offset], ty[offset], tw[offset], th[offset])))){
				fail("contains rect method failed on input: {" + tx[offset] + "," + ty[offset] + "," + tw[offset] + "," + th[offset] + "}");
				error[7] = true;
			}
		}
	}
	
	@Test
	public void testToString () {
		int [] x = {-5, -1, 0, 1, 5, 10};
		int [] y = {-5, -1, 0, 1, 5, 10};
		int [] w = {100, -100, 0, 12, 5, 0};
		int [] h = {50, -50, 0, -11, 5, 10};
		
		for(int offset = 0; offset < x.length; offset++){
			Rect testObject = new Rect(x[offset], y[offset], w[offset], h[offset]);
			if(testObject.toString() != ("[" + x[offset] + "," + y[offset] + "," + w[offset] + "," + h[offset] + "]")){
				fail("toString method failed");
				error[8] = true;
			}
		}
	}
	
	public void printErrors () {
		System.out.println("The errors I found are:");
		
		if(error[0] == true){
			System.out.println("The constructor returned an object that wasn't a Rect");
		}
		if(error[1] == true){
			System.out.println("The constructor returned a Rect that wasn't the one defined");
		}
		if(error[2] == true){
			System.out.println("Contains doesn't properly check if a point on a corner is contained in a given Rect");
		}
		if(error[3] == true){
			System.out.println("getX doesn't return the correct value");
		}
		if(error[4] == true){
			System.out.println("getY doesn't return the correct value");
		}
		if(error[5] == true){
			System.out.println("getWidth doesn't return the correct value");
		}
		if(error[6] == true){
			System.out.println("getHeight doesn't return the correct value");
		}
		if(error[7] == true){
			System.out.println("Contains doesnt work when a Rect is enclosed in another Rect");
		}
		if(error[8] == true){
			System.out.println("One of the values toString returns is incorrect");
		}
		if(error[9] == true){
			System.out.println("Contains doesn't work when a point is on the edge");
		}
		if(error[10] == true){
			System.out.println("Contains doesn't work when a point is inside the Rect");
		}
	}
}