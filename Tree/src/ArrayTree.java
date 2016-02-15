import java.util.ArrayList;


public class ArrayTree<V> {
	ArrayList<V> nodes = new ArrayList<V>();
	
	public void add(V newvalue){
		nodes.add(newvalue);
	}
	
	public V getRoot() {
		return nodes.get(0);
	}
	
	public boolean isRoot( V value){
		return value == nodes.get(0);
	}
	
	//first instance of value
	public boolean isParent(V value){
		int index = nodes.indexOf(value);
		int leftIndex = 2 * index + 1;
		int rightIndex = leftIndex + 1;
		return (leftIndex < nodes.size() || rightIndex < nodes.size());
		}
}
