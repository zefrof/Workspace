/**
 * Darren Wiltse
 *
 * This defines the window object
 */
#ifndef WINDOW_H
#define	WINDOW_H

class Window {

private:
	double width;
	double height;

public:
	Window(double w, double h); 	// Create a new window of width w, height h
	double getArea();              	// Calculate the area of this window
	double getPerimeter();          // Calculate the perimeter of this window
	void print();                   // Print info about this window to standard output
};

#endif
