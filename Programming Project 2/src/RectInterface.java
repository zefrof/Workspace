/**
 * Manage the representation of a rectangle in two-dimensions.
 */
public interface RectInterface {

 /**
 * Create a new rectangle object.
 * The corners of the new rectangle are at (x,y), (x+width,y),
 * (x,y+height) and (x+width,y+height).
 * A rectangle can have 0 width and/or height.
 *
 * @param x The x-coordinate of the upper left corner of the rectangle.
 * @param y The x-coordinate of the upper left corner of the rectangle.
 * @param width The width of the rectangle.
 * If negative, 0 will be assumed.
 * @param height The height of the rectangle.
 * If negative, 0 will be assumed.
 */
// public Rect(int x, int y, int width, int height);

 /**
 * Create a new rectangle that is just large enough to contain this
 * rectangle and another.
 * For example, if this rectangle was created as new
 * Rect(0,0,10,20) and r was created with
 * new Rect(5,10,20,30) the new rectangle will have (0,0)
 * as its upper left corner and will be 25 wide and 40 high.
 *
 * @param r The other rectangle.
 *
 * @return A new rectangle that contains this one and r.
 */
 public RectInterface add(RectInterface r);

 /**
 * See if this rectangle contains the given point.
 *
 * @param x The x-coordinate of the point.
 * @param y The y-coordinate of the point.
 *
 * @return true if the point (x,y) is inside the rectangle, false if not.
 * A point is inside if it is strictly inside or is on an edge or
 * corner.
 */
 public boolean contains(int x, int y);

 /**
 * See if this rectangle contains the given rectangle.
 *
 * @param r The other rectangle.
 *
 * @return true if this rectangle contains r, false if not.
 * This rectangle contains r if the add method (see above) returns
 * exactly this rectangle.
 */
 public boolean contains(RectInterface r);

 /**
 * Get the x-coordinate of this rectangle.
 *
 * @return the x-coordinate of the upper left corner of this rectangle.
 */
 public int getX();

 /**
 * Get the y-coordinate of this rectangle.
 *
 * @return the y-coordinate of the upper left corner of this rectangle.
 */
 public int getY();

 /**
 * Get the width of this rectangle.
 *
 * @return the width of this rectangle.
 */
 public int getWidth();

 /**
 * Get the height of this rectangle.
 *
 * @return the height of this rectangle.
 */
 public int getHeight();

 /**
 * Create a new rectangle that is the intersection of this rectangle and
 * another.
 * The intersection is a rectangle that contains the area that is common
 * to both.
 *
 * @param r The other rectangle.
 *
 * @return the intersection rectangle.
 * If there is no intersection, return null.
 */
 public RectInterface intersect(RectInterface r);


 /**
 * See if this rectangle intersects any part of another rectangle.
 *
 * @param r The other rectangle.
 *
 * @return true if any part of r intersects this one, false if not.
 * This rectangle and r intersect even if they have only one point
 * or any part of an edge in common.
 */
 public boolean intersects(RectInterface r);

 /**
 * Construct a string showing the position and size of this rectangle.
 *
 * @return the string in the form [x,y,width,height].
 */
 public String toString();

 } // end of RectInterface