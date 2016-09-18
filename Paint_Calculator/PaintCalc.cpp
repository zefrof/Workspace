/**
 * Darren Wiltse
 * CS1141
 *
 * Prompts user for input and calculates the amount of paint and tape needed
 */
#include <cstdlib>
#include <iostream>
#include <cmath>
#include "Wall.h"

using namespace std;

int main (void){

	double gallons = 0;
	double tapeLength = 0;
	double wallWidth = 0;
	double wallHeight = 0;
	double windWidth = 1;
	double windHeight = 0;


	cout << "Area per gallon? ";
	cin	>> gallons;
	cout << "Length per roll of tape? ";
	cin >>	tapeLength;

	cout << "Width of wall? ";
	cin >> wallWidth;
	cout << "Height of wall ";
	cin >> wallHeight;
	Wall *temp = new Wall(wallWidth, wallHeight);

	while(windWidth > 0){
		cout << "Width of window (<=0 if no more windows)? ";
		cin >> windWidth;
		if(windWidth > 0) {
			cout << "Height of window? ";
			cin >>	windHeight;
			temp->addWindow(windWidth, windHeight);
		}
	}
	temp->print();
	cout << ceil(temp->getPaintableArea() / gallons) << " gallons of paint\n";
	cout << ceil(temp->getTapeLength() / tapeLength) << " rolls of tape" << endl;

}
