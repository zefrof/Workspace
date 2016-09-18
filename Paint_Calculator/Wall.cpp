/**
 * Darren Wiltse
 * CS1141
 *
 * implements wall object
 */
#include <cstdlib>
#include <iostream>
#include "Wall.h"

using namespace std;

	Wall::Wall(double w, double h) {
		this->width = w;
		this->height = h;
		this->area = w * h;
	}

	void Wall::addWindow(double w, double h) {
		this->win.push_back(Window(w, h));
	}

	double Wall::getPaintableArea() {
		double pArea = this->area;
		if(this->win.size() > 0) {
			for(int i = 0; i < this->win.size(); i++){
				pArea -= this->win.at(i).getArea();
			}
		}
		return pArea;
	}

	double Wall::getTapeLength(){
		double prmtr = 0;
		if(this->win.size()) {
			for(int i = 0; i < this->win.size(); i++){
				prmtr += this->win.at(i).getPerimeter();
			}
		}
		return prmtr;
	}

	void Wall::print() {
		//3*2cout.precision(2);
		cout << "Wall [" << this->width << " x " << this->height << "], paintable area = " << this->getPaintableArea()
				<< ", tape length = " << this->getTapeLength() << ", windows = " << this->win.size() << endl;
		for(int i = 0; i < this->win.size(); i++){
			this->win.at(i).print();
		}
	}
