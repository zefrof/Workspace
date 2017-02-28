/***
 *
 * Darren Wiltse
 * Encrypts files based on a user selected key. 
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Key.h"

int main (int argc, char** argv){
	if(argc < 4){
		printf("Crypto <input file> <output file> <key file> [debug]");
		return 0;
	}

	FILE *input = fopen(argv[1], "rb");
	FILE *output = fopen(argv[2], "wb");
	Key *keyTmp = malloc(sizeof(Key));
	Stats *statTmp = malloc(sizeof(Stats));

	if(input == NULL){
		printf("Failed to open input file: %s", argv[1]);
	}
	if(output == NULL){
		fclose(output);
		printf("Failed to open output file: %s", argv[2]);
		return 0;
	}
	if(argv[3] == NULL){
		printf("Failed to load key file: %s", argv[3]);
	}

	initKey(keyTmp, argv[3]);
	initStats(statTmp);

	int pos = fgetc(input);

	while(pos != EOF){
		char ch = applyKey(keyTmp, statTmp, pos, argv[4]);
		fputc(ch, output);
		pos = fgetc(input);
	}
	printStats(statTmp);
	fclose(input);
	fclose(output);
	fclose(keyTmp->file);

	free(keyTmp);
	free(statTmp);
}
