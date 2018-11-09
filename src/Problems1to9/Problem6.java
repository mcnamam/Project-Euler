package Problems1to9;

/**
 * The sum of the squares of the first ten natural numbers is 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {

    static final int MAX = 100;
    public static void main(String[] args) {
        int sumSquares = 0;
        int sum = 0; // note that sum could also just be computed as sum = MAX*(MAX+1)/2

        // iterate through the natural numbers, adding to sumSquares and sum as we go
        for (int i = 1; i <= MAX; i++) {
            sumSquares += i * i;
            sum += i;
        }

        // compute the square of the sum
        final int squareSum = sum * sum;

        // compute the difference between the square of sums of sum of squares
        final int difference = squareSum - sumSquares;

        System.out.println("The difference between the sum of the squares of the first one hundred natural numbers and the square of the sum is " + difference);
    }
}
