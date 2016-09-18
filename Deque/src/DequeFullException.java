/**
 * Exception indicating that the deque is full.
 * Extends RuntimeException so it is unchecked.
 */
public class DequeFullException extends RuntimeException {
	public DequeFullException(String message) {
		super(message);
	}
}