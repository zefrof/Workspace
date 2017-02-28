/***
 *
 * Darren Wiltse
 *
 */
#ifndef KEY_H
#define	KEY_H
#include <stdio.h>
#include <stdbool.h>
#include "Stats.h"

typedef struct key {
	int position;
	FILE *file;
	const char *fileName;
} Key;

bool initKey(Key* key, const char* filename);                // Initialize and load from the given filename, returns false if loading of key failed
void freeKey(Key* key);                                      // Deallocate any memory used by key
char applyKey(Key* key, Stats* stats, char ch, bool debug);  // Process ch using the current position in the key, advance key, update stats, optionally print debug line, returns output character.

#endif
