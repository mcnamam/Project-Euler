package Problems1to10;

import java.util.Arrays;
import java.util.List;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {

    /**
     *  starting from 2520, (since that was given as the smallest number for 1:10)
     *  iterate over numbers and check modulo from 2:20 (1 is always true)
     *
     *  for efficiency, first check divisibility of prime numbers before checking non-primes
     *  also increment the iteration by the remainder of division
      */

    final static List<Integer> primes = Arrays.asList(2,3,5,7,11,13,17,19);
    final static List<Integer> nonPrimes = Arrays.asList(4,6,8,9,10,12,14,15,16,18,20);
    final static int START = 2520;

    public static void main(String[] args) {
        boolean found = false;
        int i = START;
        while (!found) {
            found = true;
            // iterate over primes to check divisibility
            for (int prime : primes) {
                final int remainder = i % prime;
                // if not evenly divisible for a given prime, increment i by (prime - remainder)
                // as that will be the next term evenly divisible by this prime
                if (remainder != 0) {
                    found = false;
                    i += prime - remainder;
                    break;
                }
            }
            for (int nonPrime : nonPrimes) {
                final int remainder = i % nonPrime;
                // if not evenly divisible for a given non-prime, increment i by (nonPrime - remainder)
                // as that will be the next term evenly divisible by this non-prime
                if (i % nonPrime != 0) {
                    found = false;
                    i += nonPrime - remainder;
                    break;
                }
            }
            if (found) {
                System.out.println("The smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is " + i);
            }
        }
    }
}
