/***
 *
 * Darren Wiltse
 * CS1141
 *
 */
#ifndef STATS_H
#define	STATS_H
#include <stdio.h>

typedef struct stats {
	int letters;
	int whitespace;
	int digits;
	int other;
	int total;
} Stats;

void initStats(Stats* stats);             // Initialize a stats structure
void updateStats(Stats* stats, char ch);  // Update stats based on ch output character
void printStats(Stats* stats);            // Print line of text showing number of processes characters and percent in each character class

#endif
