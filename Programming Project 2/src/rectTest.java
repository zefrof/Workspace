
public class rectTest {

	static Rect bigRect = new Rect(0, 0, 100, 100);
	static Rect smallRect = new Rect(50, 50, 100, 100);
	
	public static void main(String[] args) {
		System.out.println(bigRect.intersect(smallRect).toString());

	}

}
