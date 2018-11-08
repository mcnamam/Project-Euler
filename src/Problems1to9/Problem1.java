package Problems1to10;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {

    public static void main (String[] args) {
        final int MAX = 1000;
        int sum = 0;

        // iterate through all numbers from 3 to MAX to find multiples of 3 or 5
        for (int i = 3; i < MAX; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println("The sum of all multiple of 3 or 5 less than " + MAX + " is " + sum);
    }
}
