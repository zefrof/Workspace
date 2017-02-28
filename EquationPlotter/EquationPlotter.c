/**
 * Darren Wiltse
 * CS1141 Program 1
 * EquationPlotter; This program takes input from a user
 * and prints out a graph of an equation.
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char** argv) {
	if(argc < 4){
		printf("EquationPlotter <x_range> <y_range> <a_0> [a_1] .. [a_k]\n");
		return 0;
	} else {
		int graphX = atoi(argv[1]);
		int graphY = atoi(argv[2]);
		printf("y = %.2f", atof(argv[3]));
		if(argv[4]){
			printf(" + ");
		}
		int count = 1;
		for(int i = 4; i < argc; i++){
			printf("%.2fx^%d", atof(argv[i]), count);
			if(argv[i + 1]){
				printf(" + ");
			}
			count++;
		}
		printf("\n");



		int funcXValues[argv[1] * 2 + 1];
		int funcYValues[argv[1] * 2 + 1];

		int incriment = 1;
		int index = 0;
		for(int i = -argv[1]; i < argv[1] + 1; i++){
			if(argv[4]){
				for(int j = 4; j < argc; j++){
					funcYValues[index] += round(atof(argv[j]) * pow(i, incriment));
				}
				funcXValues[index] = i;
			} else {
				funcYValues[index] = argv[3];
				funcXValues[index] = i;
			}
			incriment++;
			index++;
		}

		for(int i = 0; i < 17; i++){
			printf("%d", funcXValues[i]);
		}
		printf("\n");
		for(int i = 0; i < 17; i++){
			printf("%d", funcYValues[i]);
		}
		printf("\n");

		for(int i = 0; i < graphY; i++){
			for(int j = 0; j < graphX * 2 + 1; j++){
				if(j == graphX){
					printf("|");
				} else {
					printf(" ");
				}
			}
			printf("\n");
		}
		for(int i = 0; i < graphX * 2 + 1; i++){
			if(i == graphX){
				printf("+");
			} else {
				printf("-");
			}
		}
		printf("\n");
		for(int i = 0; i < graphY; i++){
			for(int j = 0; j < graphX * 2 + 1; j++){
				if(j == graphX){
					printf("|");
				} else {
					printf(" ");
				}
			}
			printf("\n");
		}
	}
}
