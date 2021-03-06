/***
 * Darren Wiltse
 * dkwiltse@gmail.com
 * Unigram - This program takes a text file as input
 * and sorts it in order to train a language model.
 */
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <math.h>

// We assuming all words in this assignment are no more than 31 characters long.
// This requires 32 characters in any array that is suppose to hold a word including the null.
#define WORD_ARRAY_SIZE 32

// Function prototypes, this allows the function implementations to appear in any order in the file
unsigned int hashString(char* str);
double calcUnigramLogProb(unsigned int count, unsigned long total);
void stripLower(char* str);

void testHashString();
void testCalcUnigramLogProb();
void testStripLower();

// Hash a null-terminated string to an unsigned int.
// Implement as in Java's hashCode for String s, calculates this equation:
//   s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]  (^ denotes exponentiation)
// For Java source and discussion: http://tinyurl.com/pqg2al5
unsigned int hashString(char* str) {
	unsigned int hash = 0;
	for (int i = 0; i < strlen(str); i++) {
		hash = 31 * hash + str[i];
	}
	return hash;
}

// Calculate log probability of a word occurring count times in total words of data.
// Result is in log base 10.
double calcUnigramLogProb(unsigned int count, unsigned long total) {
	return log10(count) - log10(total);
}

// Strip the null-terminated string of characters that aren't letters or apostrophe.
// Also converts to lowercase.
// This operates in place on the string str.
void stripLower(char* str) {
	int from, to;

	for (from = 0, to = 0; str[from] != '\0'; ++from) {
		if(isupper(str[from])){
			str[from] = tolower(str[from]);
		}
		if (isupper(str[from])) {
			str[to] = tolower(str[from]);
	    }
	    if (!isdigit(str[from]) && (!ispunct(str[from]) || str[from] == '\'')) {
	    	str[to] = str[from];
	        ++to;
	    }
	}
	str[to] = '\0';
}

// Test function for the hashString function
void testHashString() {
	char tests[][WORD_ARRAY_SIZE] = { "bad", "dab", "activatable", "berserkers",
			"a", "A", "ABCDEFGHIJKLNOPQRSTUVWXYZ", "1234567890!@#$%^&*()", "" };

	int i = 0;
	while (strlen(tests[i]) > 0) {
		printf("\"%s\" -> %u\n", tests[i], hashString(tests[i]));
		i++;
	}
}

// Test function for the calcUnigramLogProb function
void testCalcUnigramLogProb() {
	const int SIZE = 8;
	unsigned int counts[] = { 5, 50, 1, 1, 1234, 0, 100, 1 };
	unsigned long totals[] = { 10, 100, 100, 2000, 567890, 123, 100, 1 };

	for (int i = 0; i < SIZE; i++) {
		printf("%5u %7lu -> %9.6f\n", counts[i], totals[i],
				calcUnigramLogProb(counts[i], totals[i]));
	}
}

// Test function for the stripLower function
void testStripLower() {
	char tests[][WORD_ARRAY_SIZE] = { "bad", "BAD", "BaD", "CAN'T", "well-done",
			"!L00K-", "1234567890", "" };

	int i = 0;
	while (strlen(tests[i]) > 0) {
		printf("\"%s\" -> ", tests[i]);
		stripLower(tests[i]);
		printf("\"%s\" (len %zu)\n", tests[i], strlen(tests[i]));
		i++;
	}
}

int main(int argc, char** argv) {
	// If no command line input we print out a help message and also run test functions
	if (argc <= 1) {
		printf("Usage: Unigram <hash table size> [debug]\n\n");
		testHashString();
		printf("\n");
		testCalcUnigramLogProb();
		printf("\n");
		testStripLower();
		return 0;
	}
	else if (atoi(argv[1]) < 0) {
		printf("Table size must be positive!\n");
	}

	int tableSize = atoi(argv[1]);
	//char** hashTable = malloc(sizeof(char*) * tableSize);
	char hashTable[WORD_ARRAY_SIZE][tableSize];
	int count[tableSize];

	int temp;
	char* tempChar;
	for(int i = 0; i < tableSize; i++){
		printf("%s\n", "loop started");
		*tempChar = scanf("%s", argv[i + 1]);
		printf("%s\n", "tempChar scanned in");
		stripLower(tempChar);
		printf("%s\n", "stripLower ran");
		if(strlen(tempChar) > 31){
			printf("%s\n", "if is going");
			temp = hashString(argv[i + 1]) % tableSize;
			hashTable[0][temp] = *tempChar;
			count[temp]++;
		} else {
			printf("%s\n", "else is triggered");
		}
	}

	printf("%s\n", "for loop runs");



	return 0;
}
