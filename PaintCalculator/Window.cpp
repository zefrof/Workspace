/**
 * Darren Wiltse
 *
 * implements the window object.
 */
#include <cstdlib>
#include <iostream>
#include "Window.h"

	Window::Window(double w, double h) {
		this->width = w;
		this->height = h;
	}

	double Window::getArea() {
		return this->width * this->height;
	}

	double Window::getPerimeter() {
		return (this->width * 2) + (this->height * 2);
	}

	void Window::print() {
		//std::cout.precision(2);
		std::cout << "Window [" << this->width << " x " << this->height << "], area = "
				<< this->getArea() << ", perimeter = " << this->getPerimeter() << std::endl;
	}
