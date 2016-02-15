
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue foo = new Queue(10);
		try {
			foo.enqueue(1);
		} catch (QueueFullException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			foo.enqueue(2);
		} catch (QueueFullException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			foo.enqueue(3);
		} catch (QueueFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(foo.toString());
	}

}
