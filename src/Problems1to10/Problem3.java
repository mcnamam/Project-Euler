package Problems1to10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {

    private static final String MAX_NUMBER_STRING = "600851475143";
    private static long n = Long.parseLong(MAX_NUMBER_STRING);
    private static boolean[] primes;
    private static Set<Integer> primeNumbers = new HashSet<>();
    private static int minComputedPrime = 2;

    public static void main(String args[]) {
        // find all possible factors of n
        final List<Integer> factors = new ArrayList<>();
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                factors.add((int)i);
                n = n / i;
            }
        }
        // find the largest factor of n by sorting factors in decreasing order
        factors.sort((i1, i2) -> Integer.compare(i2,i1));
        final int maxFactor = factors.get(0);

        // create a boolean array of size maxFactor+1 which will be used
        // to flag numbers that are prime
        // e.g. if primes[i] == true  =>  i is a prime number
        primes = new boolean[maxFactor+1];

        // initialize primes to be all true
        for (int i = minComputedPrime; i < primes.length; i++) {
            primes[i] = true;
        }

        // iterate through the list of factors, from largest to smallest,
        // to find the largest prime factor
        for (int i : factors) {
            if (isPrime(i)) {
                System.out.println("Max prime factor of " + MAX_NUMBER_STRING + " is " + i);
                break;
            }
        }
    }

    /**
     *   This function implements a Sieve of Eratosthenes approach to finding prime numbers
     *   https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     *
     *   Numbers are marked as prime/non-prime in the primes boolean array (index in the array
     *   corresponds to the number itself).  There is a separate set of integers 'primeNumbers'
     *   which is used to track the numbers that have been verified to be prime so far.
     */
    private static boolean isPrime(final int x) {
        // check if it has already been marked as prime
        if (primeNumbers.contains(x)) {
            return true;
        }

        // check if it is a multiple of a number that is already known to be prime
        for (int i : primeNumbers) {
            if (x % i == 0) {
                return false;
            }
        }

        // this is the Sieve of Eratosthenes part
        // progress through numbers less than x, starting at the most recently discovered prime
        // Mark those which are not prime
        for (int i = minComputedPrime; i < x; ) {
            primeNumbers.add(i);
            // if x is a multiple of the most recently discovered prime, then it is not prime
            if (x % i == 0) {
                return false;
            }

            // mark all multiples of the most recently discovered prime to be non-prime
            for (int j = 2 * i; j < primes.length; j += i) {
                primes[j] = false;
            }

            // discover the next prime by starting just past the most recently discovered prime and
            // iterating until you find an index in primes array that has not been marked as non-prime
            int nextPrime = i;
            for (int j = nextPrime + 1; j < primes.length; j++) {
                if (primes[j]) {
                    nextPrime = j;
                    break;
                }
            }

            // sanity check: if nextPrime has not been updated then we have found 0 primes between i and x
            // since we already checked if x is divisible by previously discovered primes, then x must be prime
            if (nextPrime == i) {
                return true;
            }

            // update i and minComputedPrime for next pass through the loop
            i = nextPrime;
            minComputedPrime = i;
        }

        return true;
    }
}
