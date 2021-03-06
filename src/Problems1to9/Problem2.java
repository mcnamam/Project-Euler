package Problems1to9;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class Problem2 {

    public static void main (String[] args) {
        final int MAX = 4000000;
        int previousTerm = 1;
        int currentTerm = 1;
        int sum = 0;

        // simple iterative approach to find Fibonacci terms
        while (currentTerm <= MAX) {
            if (currentTerm % 2 == 0) {
                sum += currentTerm;
            }
            final int nextTerm = previousTerm + currentTerm;
            previousTerm = currentTerm;
            currentTerm = nextTerm;
        }

        System.out.println("The sum of all even-valued terms in the Fibonacci sequence up to " + MAX + " is " + sum);
    }

}
