/**
 * This program is an implementation of the rectangle class
 * 
 * @author Darren Wiltse
 * 
 * CS1122, Fall 2015, Section 1
 */

public class Rect implements RectInterface {

	int[] rectAttributes = new int[4];
	
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
	public Rect(int x, int y, int width, int height){
		rectAttributes[0] = x;
		rectAttributes[1] = y;
		
		if(width < 0){
			rectAttributes[2] = 0;
		} else {
			rectAttributes[2] = width;
		}
		
		if(height < 0){
			rectAttributes[3] = 0;
		} else {
			rectAttributes[3] = height;
		}
	}
	
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
	@Override
	public RectInterface add(RectInterface r) {
		if(rectAttributes[0] <= r.getX() && rectAttributes[1] <= r.getY()){
			return new Rect(rectAttributes[0], rectAttributes[1],
					r.getX() + r.getWidth(), r.getY() + r.getHeight());
		} else if(rectAttributes[0] <= r.getX() && rectAttributes[1] >= r.getY()){
			return new Rect(rectAttributes[0], r.getY(),
					r.getX() + r.getWidth(), rectAttributes[1] + rectAttributes[3]);
		} else {
			return new Rect(r.getX(), rectAttributes[1],
					rectAttributes[0] + rectAttributes[2], r.getY() + r.getHeight());
		}
	}

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
	@Override
	public boolean contains(int x, int y) {
		if(rectAttributes[0] <= x && (rectAttributes[0] + rectAttributes[2]) >= x 
				&& rectAttributes[1] <= y && (rectAttributes[1] + rectAttributes[3]) >= y){
			return true;
		} else {
			return false;
		} 
	}

	 /**
	 * See if this rectangle contains the given rectangle.
	 *
	 * @param r The other rectangle.
	 *
	 * @return true if this rectangle contains r, false if not.
	 * This rectangle contains r if the add method (see above) returns
	 * exactly this rectangle.
	 */
	@Override
	public boolean contains(RectInterface r) {
		if(rectAttributes[0] <= r.getX() && rectAttributes[1] <= r.getY()
				&& rectAttributes[2] >= r.getWidth() && rectAttributes[3] >= r.getHeight()){
			return true;
		} else{
			return false;
		}
	}

	 /**
	 * Get the x-coordinate of this rectangle.
	 *
	 * @return the x-coordinate of the upper left corner of this rectangle.
	 */
	@Override
	public int getX() {
		return rectAttributes[0];
	}

	/**
	 * Get the y-coordinate of this rectangle.
	 *
	 * @return the y-coordinate of the upper left corner of this rectangle.
	 */
	@Override
	public int getY() {
		return rectAttributes[1];
	}

	 /**
	 * Get the width of this rectangle.
	 *
	 * @return the width of this rectangle.
	 */
	@Override
	public int getWidth() {
		return rectAttributes[2];
	}

	 /**
	 * Get the height of this rectangle.
	 *
	 * @return the height of this rectangle.
	 */
	@Override
	public int getHeight() {
		return rectAttributes[3];
	}

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
	@Override
	public RectInterface intersect(RectInterface r) {
		if(this.intersects(r)){
			if(r.getX() >= rectAttributes[0] && r.getY() >= rectAttributes[1]){
				return new Rect(r.getX(), r.getY(), rectAttributes[2] - r.getX(), 
						rectAttributes[3] - r.getY());
			} else {
				if(r.getX() >= rectAttributes[0] && r.getY() <= rectAttributes[1]) {
					return new Rect(r.getX() + rectAttributes[0], r.getY(), 
							(r.getX() + rectAttributes[0]) + (rectAttributes[0] + rectAttributes[2]),
							r.getY() + (r.getX() + r.getHeight()));
				} else {
					return new Rect(r.getX() + rectAttributes[0], rectAttributes[1], 
							(r.getX() + rectAttributes[0]) + (r.getX() + r.getWidth()),
							rectAttributes[1] + (rectAttributes[0] + rectAttributes[3]));
				}
			}
		} else {
			return null;
		}
	}

	/**
	 * See if this rectangle intersects any part of another rectangle.
	 *
	 * @param r The other rectangle.
	 *
	 * @return true if any part of r intersects this one, false if not.
	 * This rectangle and r intersect even if they have only one point
	 * or any part of an edge in common.
	 */
	@Override
	public boolean intersects(RectInterface r) {
		if(r.getX() >= rectAttributes[0] && r.getX() <= rectAttributes[2]
				&& r.getY() >= rectAttributes[1] && r.getY() <= rectAttributes[3]){
			return true;
		} else if(r.getWidth() >= rectAttributes[0] && r.getWidth() <= rectAttributes[2]
				&& r.getHeight() >= rectAttributes[1] && r.getHeight() <= rectAttributes[3]){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construct a string showing the position and size of this rectangle.
	 *
	 * @return the string in the form [x,y,width,height].
	 */
	@Override
	public String toString (){
		return "[" + rectAttributes[0] + "," + rectAttributes[1] + "," 
				+ rectAttributes[2] + "," + rectAttributes[3] + "," + "]";
	}
}