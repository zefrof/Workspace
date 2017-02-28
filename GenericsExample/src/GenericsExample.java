
public class GenericsExample {

	public static void main(String[] args) {
		KeyValuePair<String, Integer> foo = new KeyValuePair<String, Integer> ("A", 5);
		int bar = foo.getValue();
		System.out.println(bar);
	}
}
