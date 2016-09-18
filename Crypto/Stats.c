/***
 *
 * Darren Wiltse
 * CS1141
 *
 */
#include <stdio.h>
#include <ctype.h>
#include "Stats.h"

void initStats(Stats* stats){
	stats -> letters = 0;
	stats -> whitespace = 0;
	stats -> digits = 0;
	stats -> other = 0;
	stats -> total = 0;
}

void updateStats(Stats* stats, char ch){
	if(isalpha(ch)){
		stats->letters++;
	} else if(isdigit(ch)){
		stats->digits++;
	} else if(isspace(ch)){
		stats->whitespace++;
	} else{
		stats->other++;
	}
	stats->total++;
}

void printStats(Stats* stats){
	double charCount = (double)(stats->letters) * 100 / (stats->total);
	double spaceCount = (double)(stats->whitespace) * 100 / (stats->total);
	double digitCount = (double)(stats->digits) * 100 / (stats->total);
	double otherCount = (double)(stats->other) * 100 / (stats->total);
	printf("Output %d characters: %.2f%% letters, %.2f%% spaces, %.2f%% numbers, %.2f%% other\n",
			stats->total, charCount, spaceCount, digitCount, otherCount);
}
