/**
 * --------------------------------------------------------------------------
 * CLASS: EmptyPriorityQueueException
 * @author ureel
 * @see RuntimeException
 * DESCRIPTION: Exception raised when an operation is performed on an empty priority.
 * --------------------------------------------------------------------------
 * MODIFICATIONS:
 *   2013/09/15 UREEL: Created
 * --------------------------------------------------------------------------
 */
public class EmptyPriorityQueueException extends RuntimeException {
   private static final long serialVersionUID = -6793999146687610984L;
   public EmptyPriorityQueueException( ) {
      super( );
   }
   public EmptyPriorityQueueException( String message ) {
      super( message );
   }
}
