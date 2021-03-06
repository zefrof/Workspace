/**
 * Darren Wiltse
 * NumberHunt: This program randomly generates a number between 1 and 100.
 * Then the user tries to guess the number.
 */
#import <stdio.h>
#import <stdlib.h>
#import <time.h>

int main(int argc, char** argv){
	int randNum = 0;

	if(argc == 2){
		randNum = atoi(argv[1]);
	} else {
		srand ( time(NULL) );
		randNum = rand() % 100 + 1;
		//printf("%d", randNum);

	}
	int guess = 0;
	int guessCount = 0;
	while(guess != randNum){
		scanf("%d", &guess);

		if(guess == randNum){
			printf("Number? You entered %d.\n", guess);
			printf("You nailed it!\n");
			if(guessCount == 0){
				printf("It took you %d guess.\n", guessCount + 1);
			} else {
				printf("It took you %d guesses.\n", guessCount + 1);
			}
		} else if(guess > 100 || guess <= 0){
			printf("Number? You entered %d.\n", guess);
			printf("Invalid input!\n");
		} else if(guess == randNum + 1 || guess == randNum - 1){
			printf("Number? You entered %d.\n", guess);
			printf("On fire.\n");
		} else if((guess <= randNum + 5 && guess >= randNum + 2) ||
				(guess >= randNum - 5 && guess <= randNum - 2)){
			printf("Number? You entered %d.\n", guess);
			printf("Hot.\n");
		} else if ((guess <= randNum + 10 && guess >= randNum + 6) ||
				(guess >= randNum - 10 && guess <= randNum - 6)){
			printf("Number? You entered %d.\n", guess);
			printf("Getting warmer.\n");
		} else if((guess <= randNum + 19 && guess >= randNum + 11) ||
				(guess >= randNum - 19 && guess <= randNum - 11)){
			printf("Number? You entered %d.\n", guess);
			printf("Cold.\n");
		} else if((guess <= randNum + 99 && guess >= randNum + 20) ||
				(guess >= randNum - 99 && guess <= randNum - 20)) {
			printf("Number? You entered %d.\n", guess);
			printf("Ice cold.\n");
		}
		guessCount++;
	}
}
