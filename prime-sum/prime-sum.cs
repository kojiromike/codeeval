using System.IO;

class Program {
    static bool isPrime(int i) {
        int j;
        if (i == 2) return true;
        if (i % 2 == 0) return false;
        for (j = 3; j * j <= i; j += 2) {
            if (i % j == 0) return false;
        }
        return true;
    } 

    static void Main(string[] args) {
        // Print to stdout the sum of the first 1000 prime numbers.
        int sum = 0;
        int i = 2;
        int foundPrimes = 0;
        while (foundPrimes < 1000) {
            if (isPrime(i)) {
                sum += i;
                foundPrimes += 1;
            }
            i += 1;
        }
        System.Console.WriteLine(sum);
    }
}
