package Problems10to19;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */

public class Problem10 {
    private static final int UPPER_BOUND = 2000000;
    // make an array of size UPPER_BOUND * 2 to allow us to
    // find all primes up to and just beyond UPPER_BOUND
    private static boolean[] primes = new boolean[UPPER_BOUND*2];
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
        // start at 2
        int lastPrimeFound = 2;
        long sumOfPrimes = 2;

        while(true) {
            // mark all multiples of the most recently discovered prime to be non-prime
            for (int j = 2 * lastPrimeFound; j < primes.length; j += lastPrimeFound) {
                primes[j] = false;
            }

            // discover the next prime by starting just past the most recently discovered prime and
            // iterating until you find an index in primes array that has not been marked as non-prime
            for (int j = lastPrimeFound + 1; j < primes.length; j++) {
                if (primes[j]) {
                    lastPrimeFound = j;
                    break;
                }
            }

            // loop until we find a prime number >= UPPER_BOUND
            if (lastPrimeFound < UPPER_BOUND) {
                sumOfPrimes += lastPrimeFound;
            } else {
                break;
            }
        }

        System.out.println("The sum of all primes less than " + UPPER_BOUND + " is " + sumOfPrimes);
    }
}
