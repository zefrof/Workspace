import java.util.ArrayList;


public class Sorts {
	
	public ArrayList<Integer> bubbleSort (ArrayList<Integer> source) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int j = 0; j < source.size(); j++){
			result.add(source.get(j));
		}
		for(int i = 0; i < result.size(); i++){
			for(int k = i; k < result.size() - 1; k++){
				if(source.get(k + 1) < result.get(k)){
					int temp = result.get(k + 1);
					result.set(k, result.get(k + 1));
					result.set(k + 1, temp);
				}
			}
		}
		return result;
	}
	

	public ArrayList<Integer> insertionSort (ArrayList<Integer> source) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int j = 0; j < source.size(); j++){
			result.add(source.get(j));
		}
		for(int i = 1; i < source.size(); i++){
			int temp = result.get(i);
			int k;
			for(k = i - 1; k >= 0; k--){
				if(temp < result.get(k)){
					result.set(k + 1, result.get(k));
				} else {
					break;
				}
			}
			result.set(k + 1, temp);
		}
		
		return result;
	} 
	
	public static void main(String[] args) {
		Sorts sorts = new Sorts();
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(7);
		array.add(-1);
		array.add(12);
		array.add(20);
		array.add(17);
		
		System.out.println("Source Array: " + array);
		System.out.println("BubbleSort: " + sorts.bubbleSort(array));
		System.out.println("InsetionSort: " + sorts.insertionSort(array));
	}
}
