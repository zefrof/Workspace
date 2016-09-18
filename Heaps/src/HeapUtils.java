
public class HeapUtils<V extends Comparable<V>> implements HeapUtilsInterface<V> {

	
	@Override
	public int getIndexOfLeftChild(int parentIndex) {
		return (2 * parentIndex) + 1;
	}

	@Override
	public int getIndexOfRightChild(int parentIndex) {
		return (2 * parentIndex) + 2;
	}

	@Override
	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	@Override
	public void bubbleUp(V[] data, int index) {
		int parIndex = getParentIndex(index);
        while(data[parIndex].compareTo(data[index]) > 0) {
            swap(index, parIndex, data);
        }
	}

	@Override
	public void bubbleDown(V[] data, int index, int partitionBoundaryIndex) {
		
	}

	@Override
	public void InplaceHeapSort(V[] data) {
		// TODO Auto-generated method stub
		
	}
	
	public void swap(int indexOne, int indexTwo, V[] data) {
		V v = data[indexOne];
		data[indexOne] = data[indexTwo];
		data[indexOne] = v;
	}
}