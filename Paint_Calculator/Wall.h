/**
 * Darren Wiltse
 * CS1141
 *
 * This defines the wall object
 */
#ifndef WALL_H
#define	WALL_H
#include <vector>
#include "Window.h"

using namespace std;

class Wall{

private:
	double width;
	double height;
	double area;
	vector<Window> win;

public:
	Wall(double w, double h);      			// Create a new wall of width w, height h
	void addWindow(double w, double h); 	// Add a window of width w, height h to wall
	double getPaintableArea();           	// Area of the wall that requires paint
	double getTapeLength();               	// Length of tape needed to mask all windows
	void print();                       	// Print info about this wall to standard output
};
#endif
