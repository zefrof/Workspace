/**
 * Darren Wiltse
 * GreedyPath:
 */
#import <stdio.h>
#import <stdlib.h>

int main(int argc, char** argv){
	int numPoints = 0;
	sscanf(argv[1],"%d", &numPoints);
	double xVals[numPoints];
	double yVals[numPoints];

	for(int i = 0; i < numPoints * 2; i++){
		double temp = atof(argv[i + 2]);
		//printf("%fl", temp);
		if(i <= numPoints){
			xVals[i] = temp;
		} else {
			yVals[i] = temp;
		}
	}

	for(int i = 0; i < numPoints; i++){
		printf("%f %f\n", xVals[i], yVals[i]);
	}

	printf("\n%d", numPoints);
}
