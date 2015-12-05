#include <stdio.h>

/**
 * Indicate if the given integer is a palindrome
 * in base 10. Error if the input is larger than
 * 999.
 */
int isPalindrome(int i) {
    if (i < 10) return 1;
    if (i < 100) return ( (i / 10) == (i % 10) );
    if (i < 1000) return ( (i / 100) == (i % 10) );
    return -1; // error
}

/**
 * Prime an array of flags to indicate if a number
 * is composite or prime.
 *
 * 0 means it may be prime
 * 1 means it's definitely composite.
 */
void primePrimes(int composites[], int max) {
    int i;
    int j;
    for (i = 0; i < max; i++) {
        composites[i] = 0;
    }
    for (i = 2; i < max; i++) {
        if (composites[i]) continue;
        for (j = 2 * i; j <= i; j += i) {
            composites[j] = 1;
        }
    }
}

/**
 * Determine if a number is prime
 */
int isPrime(int i) {
    const int MAX = 32; // Only need up to about sqrt(1000)
    static int composites[MAX];
    int j;
    if (composites[2] == 0) {
        primePrimes(composites, MAX);
    }
    if (i < sizeof(composites)) {
        return !composites[i];
    }
    for (j = 2; j < sizeof(composites); j++) {
        if (composites[j]) continue;
        if ((i % j) == 0) return 0;
    }
    return 1;
}

/**
 * Find the largest prime palindrome less than MAX
 */
int main(int argc, const char * argv[]) {
    int i;
    for (i = 999; i > 2; i--) {
        if (isPalindrome(i) && isPrime(i)) {
            printf("%d\n", i);
            break;
        }
    }
    return 0;
}
