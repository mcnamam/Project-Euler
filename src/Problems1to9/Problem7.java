package Problems1to10;

import java.lang.Math;
import java.lang.Integer;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 */

public class Problem7 {
    private static final int N = 10001;
    // based on prime number theorem, the nth prime < n * ln(n) + n * ln(ln(n))  for n ≥ 6
    private static final int UPPER_BOUND = (int)( N * Math.log(N) + N * Math.log(Math.log(N)));
    private static boolean[] primes = new boolean[UPPER_BOUND];
    static {
        // initialize primes to be all true
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
    }

    /**
     *   Use a Sieve of Eratosthenes approach to find prime numbers starting from 2
     *   https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     *
     *   Numbers are marked as prime/non-prime in the primes boolean array (index in the array
     *   corresponds to the number itself).  There is a separate set of integers 'primeNumbers'
     *   which is used to track the numbers that have been verified to be prime so far.
     */
    public static void main(String[] args) {
        int numPrimesFound = 1; // starting from 2, the first prime
        int lastPrimeFound = 2;

        // loop until N primes are found, starting at 2
        while(numPrimesFound < N) {

            // mark all multiples of the most recently discovered prime to be non-prime
            for (int j = 2 * lastPrimeFound; j < primes.length; j += lastPrimeFound) {
                primes[j] = false;
            }

            // discover the next prime by starting just past the most recently discovered prime and
            // iterating until you find an index in primes array that has not been marked as non-prime
            for (int j = lastPrimeFound + 1; j < primes.length; j++) {
                if (primes[j]) {
                    numPrimesFound++;
                    lastPrimeFound = j;
                    break;
                }
            }
        }

        System.out.println("The " + Integer.toString(N) + "th prime number is " + lastPrimeFound);
    }


}
