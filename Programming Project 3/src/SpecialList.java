import java.util.*;

/**
 * @author Darren Wiltse
 * 
 *         CS1122
 * 
 *         A SpecialList is a singly-linked list without header/trailer nodes.
 *         What is special about it is that although duplicate values are
 *         allowed, there will never be two consecutive elements with the same
 *         value. For example, [4,9,4] is okay, but [4,4,9] should never occur.
 */
@SuppressWarnings("serial")
public class SpecialList extends AbstractSpecialList {

	Node current;
	Node preCurrent;
	Node tail;

	int size = 0;

	public SpecialList() {
		tail = first;
		current = first;
	}

	/**
	 * Add an value to the list at a given position. All values starting at that
	 * position are moved over one position. If the position is less than or
	 * equal to 0, the new value is added to the front of the list. If the
	 * position is greater than or equal to the number of elements in the list,
	 * the new value is added to the end of the list. Make sure the resulting
	 * list does not have two consecutive equal values.
	 *
	 * @param pos
	 *            The position.
	 * @param value
	 *            The value to be added.
	 */
	public void add(int pos, int value) {
		if (first == null) {
			first = new Node(value, null);
			tail = first;
			size++;
		} else {
			if (pos <= 0) {
				if (first.getValue() != value) {
					first = new Node(value, first);
					size++;
				}
			} else if (pos >= this.length()) {
				if (tail.getValue() != value) {
					tail.setNext(new Node(value, null));
					tail = tail.getNext();
					size++;
				}
			} else {
				int count = 0;
				current = first;
				while (count < pos) {
					preCurrent = current;
					current = current.getNext();
					count++;
				}
				if (preCurrent.getValue() != value
						&& current.getValue() != value) {
					preCurrent.setNext(new Node(value, current));
					size++;
				}
			}
		}
	} // end of add method

	/**
	 * Get the current length of the list.
	 *
	 * @return The current length.
	 */

	public int length() {
		if (first == null) {
			return 0;
		}
		return size;
	} // end of length method

	/**
	 * Remove all values from the list.
	 */
	public void clear() {
		if (first != null) {
			while (first.getNext() != null) {
				Node tempHead = first.getNext();
				first.setNext(null);
				first = tempHead;
			}
			first = null;
			tail = first;
			current = first;
			preCurrent = null;
		}
	} // end of clear method

	/**
	 * Get the value at the given position.
	 *
	 * @param pos
	 *            The position to get the value from. If position is less than
	 *            0, the first element is assumed. If position is greater than
	 *            or equal to the number of elements in the list, the last
	 *            element is assumed
	 *
	 * @return The value at the given position. If there are no values in the
	 *         list, 0 is returned.
	 */
	public int valueAt(int pos) {
		if (first == null) {
			return 0;
		} else if (pos >= this.length()) {
			return tail.getValue();
		} else if (pos <= 0) {
			return first.getValue();
		} else {
			current = first;
			int count = 0;
			while (count < pos) {
				current = current.getNext();
				count++;
			}
			return current.getValue();
		}
	} // end of valueAt method

	/**
	 * Find the positions of all occurrences of a given value.
	 *
	 * @param value
	 *            The value to search for.
	 *
	 * @return The positions of the value in the list (the positions should be
	 *         in increasing order). If the value is not in the list, return a
	 *         vector with no elements.
	 */
	public Vector<Integer> positionsOf(int value) {
		Vector<Integer> v = new Vector<Integer>();
		current = first;
		if (this.length() != 0) {
			int count = 0;
			while (current.getNext() != null) {
				if (current.getValue() == value) {
					v.add(count);
				}
				count++;
				current = current.getNext();
			}
			if (tail.getValue() == value) {
				v.add(count++);
			}
			return v;
		} else {
			return v;
		}
	} // end of positionsOf method

	/**
	 * Remove the value at the given position. Make sure the resulting list does
	 * not have two consecutive equal values.
	 *
	 * @param pos
	 *            The position of the value to be omit. If position is less than
	 *            0, the first element is assumed. If position is greater than
	 *            or equal to the number of elements in the list, the last
	 *            element is assumed
	 */
	public void omit(int pos) {
		if (first != null) {
			if (pos <= 0) {
				current = first;
				first = first.getNext();
				current.setNext(null);
				size--;
			} else if (pos >= this.length() - 1) {
				current = first;
				while (current.getNext() != tail) {
					current = current.getNext();
				}

				current.setNext(null);
				size--;
			} else {
				current = first;
				for (int i = 0; i < pos; i++) {
					preCurrent = current;
					current = current.getNext();
				}
				if (current.getNext() != null) {
					preCurrent.setNext(current.getNext());
					current.setNext(null);
					size--;
				}
			}
		}
		current = first;
		for (int i = 0; i < this.length(); i++) {
			if (current.getNext() != null) {
				if (current.getValue() == current.getNext().getValue()) {
					current.getNext().setNext(null);
					current.setNext(current.getNext());
					size--;
				}
				current = current.getNext();
			}
		}

	} // end of omit method

	/**
	 * Shuffle the list. Split the list in half (with the extra element if the
	 * list has an odd number of elements) in the first half. Then construct a
	 * new list by starting with the first element if the first half, then
	 * appending the first element of the second list, then appending the second
	 * element of the first list, then appending the second element of the
	 * second list, etc. For example, if the list is [1,2,3,4,5,6,7], then the
	 * list after shuffling is [1,5,2,6,3,7,4]. Make sure the resulting list
	 * does not have two consecutive equal values.
	 */
	public void shuffle() {
		SpecialList spList = new SpecialList();
		if (this.length() % 2 == 0) {
			for (int i = 0; i == this.length() / 2; i++) {
				current = first;
				spList.add(i, current.getValue());
				this.omit(0);
			}
		} else {
			for (int i = 0; i == this.length() / 2 + 1; i++) {
				current = first;
				spList.add(i, current.getValue());
				this.omit(0);
			}
		}
		int count = 1;
		current = first;
		while (this.length() != 0) {
			spList.add(count, first.getValue());
			current = first.getNext();
			this.omit(0);
			first = current;
			count += 2;
		}
		spList.current = spList.first;
		for (int i = 0; i < spList.length(); i++) {
			this.add(i, spList.current.getValue());
			spList.current = spList.current.getNext();
		}
		spList.clear();
	} // end of shuffle method

	/**
	 * Move the largest value in the list to the end of the list. If the largest
	 * value occurs more than once, move the last occurrence of that value to
	 * the end. For example, if the list is [4,9,3,2,9,6,0], then afterwards is
	 * [4,9,3,2,6,0,9]. Make sure the resulting list does not have two
	 * consecutive equal values.
	 */
	public void move() {

	} // end of move method

} // end of SpecialList class