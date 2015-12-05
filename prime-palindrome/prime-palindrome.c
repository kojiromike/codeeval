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
 * Determine if a number is prime
 */
int isPrime(int i) {
    // Only need primes up to about sqrt(1000)
    // Easiest and most compact just to write this out by hand.
    static int primes[11] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    int j;
    for (j = 0; j < 11; j++) {
        if (i == primes[j]) return 1;
        if ((i % primes[j]) == 0) return 0;
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
