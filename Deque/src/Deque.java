/***
 * 
 * @author Darren Wiltse
 * dkwiltse@gmail.com
 * This class impliments the Deque interface 
 *
 */
public class Deque<E> implements DequeInterface<E> {
	
	public static void main(String[] args) {
		

	}
	
	E[] arr;
	int firstIndex;
	int lastIndex;
	int size;
	
	@SuppressWarnings("unchecked")
	public Deque(){
		arr = (E[])new Object[100];
		firstIndex = 0;
		lastIndex = 0;
		size = 0;
	}

	@Override
	public E[] getArray() {
		return arr;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(arr[firstIndex] == null){
			return true;
		}
		return false;
	}

	@Override
	public E first() {
		return arr[firstIndex];
	}

	@Override
	public E last() {
		return arr[lastIndex];
	}

	@Override
	public void addFirst(E e) throws DequeFullException{
		if(this.size == 100){
			throw(new DequeFullException("The deque is full, so the value can't be added!"));
		}
		if(this.isEmpty() == true){
			arr[0] = e;
			firstIndex = 0;
			size++;
		} else if(firstIndex == 0){
			arr[99] = e;
			firstIndex = 99;
			size++;
		} else {
			arr[firstIndex - 1] = e;
			firstIndex--;
			size++;
		}
		
	}

	@Override
	public void addLast(E e) throws DequeFullException{
		if(this.size == 100){
			throw(new DequeFullException("The deque is full, so the value can't be added!"));
		}
		if(this.isEmpty() == true){
			arr[0] = e;
			lastIndex = 0;
			size++;
		} else if(lastIndex == 99){
			arr[0] = e;
			lastIndex = 0;
			size++;
		} else {
			arr[lastIndex + 1] = e;
			lastIndex++;
			size++;
		}
		
	}

	@Override
	public E removeFirst() {
		E temp = arr[firstIndex];
		arr[firstIndex] = null;
		if(firstIndex == 99){
			firstIndex = 0;
		} else {
			firstIndex++;
		}
		size--;
		return temp;
	}

	@Override
	public E removeLast() {
		E temp = arr[lastIndex];
		arr[lastIndex] = null;
		if(lastIndex == 0){
			lastIndex = 99;
		} else {
			lastIndex--;
		}
		size--;
		return temp;
	}

}