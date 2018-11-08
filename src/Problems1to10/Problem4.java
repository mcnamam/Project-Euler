package Problems1to10;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

    // iterate over all 3 digit numbers, going from largest to smallest, to find first palindromic product
    // brute-force approach that computes and checks the product of every 3 digit number until a palindrome is found
    public static void main(String[] args) {
        int largestPalindrome = 0;
        // split the iteration into upper and lower halves and start with upper half as that is likely to be where
        // the largest palindrome is
        for (int i=999; i > 500; i--) {
            for (int j = i; j > 500; j--) {
                final int product = i*j;
                if (product > largestPalindrome && isPalindrome(product)) {
                    largestPalindrome = product;
                }
            }
        }

        // if have not found a palindrome by now, then try iterating through lower half of 3 digit numbers
        if (largestPalindrome == 0) {
            for (int i=500; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    final int product = i*j;
                    if (product > largestPalindrome && isPalindrome(product)) {
                        largestPalindrome = product;
                    }
                }
            }
        }

        System.out.println("The largest palindrome made from the product of two 3-digit numbers is " + largestPalindrome);
    }

    /**
     * This functions determines if a given number is a palindrome by converting it
     * to a String and comparing characters
     */
    private static boolean isPalindrome(final int n) {
        final String s = "" + n + "";
        final int length = s.length();
        for (int i=0; i < length/2; i++) {
            if (s.charAt(i) != s.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }
}
