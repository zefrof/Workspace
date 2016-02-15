import java.util.ArrayList;
import java.util.List;

public class ExceptionExample {
	
	public int processList (ArrayList<Number> l) throws MyException {
		for(Number n : l){
			if(n instanceof Float){
				throw(new MyException("Found a Float", n));
			}
		}
		return 0;
	}

	public static void main(String[] args) throws MyException{
		ArrayList<Number> list = new ArrayList<Number>();
		ExceptionExample self = new ExceptionExample();
		list.add(1);
		list.add(5.0);
		list.add(62.5F);
		list.add(12L);
		try {
			self.processList(list);
		} catch (MyException e){
			System.out.println(e.getMessage());
			e.printStackTrace(System.err);
		}

	}

}
