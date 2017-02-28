/***
 *
 * Darren Wiltse
 *
 */
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "Key.h"

bool initKey(Key* key, const char* filename){
	if(key == NULL){
		return false;
	}
	key->file = fopen(filename, "rb");
	key->position = fgetc(key->file);
	key->fileName = filename;
	return true;
}

void freeKey(Key* key){
	free(key);
}

char applyKey(Key* key, Stats* stats, char ch, bool debug){
	//int pos = key->position;
	int encode = 0;
	key->position = fgetc(key->file);
	if(key->position == EOF){
		fclose(key->file);
		key->file = NULL;
		key->file = fopen(key->fileName, "rb");
		key->position = fgetc(key->file);
	}
	encode = key->position ^ ch;
	updateStats(stats, encode);


	if(debug){
		if(ch <= 32 || ch >= 126){
			printf("%d '~' ^ %d '%c' -> %d '%c' \n", ch, key->position, key->position, encode, encode);
		} else if(key->position <= 32 || key->position >= 126){
			printf("%d '%c' ^ %d '~' -> %d '%c' \n", ch, ch, key->position, key->position, encode);
		} else if(encode <= 32 || encode >= 126){
			printf("%d '%c' ^ %d '%c' -> %d '~' \n", ch, ch, key->position, key->position, encode);
		} else {
			printf("%d '%c' ^ %d '%c' -> %d '%c' \n", ch, ch, key->position, key->position, encode, encode);
		}
	}
	return encode;
}


