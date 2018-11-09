package Problems1to9;

import java.lang.Math;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2
 *
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class Problem9 {

    private static final int SUM = 1000;
    private static int[] SQUARES = new int[SUM+1]; // add one since arrays are 0-indexed
    // calculate the squares of every number up to 1000 and store in SQUARES array
    // Note: SQUARES[i] = i^2
    static {
        for (int i=2; i<SQUARES.length; i++) {
            SQUARES[i] = i*i;
        }
    }

    public static void main(String[] args) {
        // iterate backwards from SUM to 1/3rd of SUM
        // (a and b must be < c, therefore for a + b + c = SUM, c has to be > SUM/3
        for (int c=SUM-2; c>SUM/3; c--) {
            // iterate from 1 up to SUM - c
            for (int a=1; a<SUM-c; a++) {
                final int b = SUM - c - a;
                // check if c^2 == a^2 + b^2
                if (SQUARES[c] == SQUARES[a] + SQUARES[b]) {
                    final int product = a*b*c;
                    System.out.println("The Pythagorean triplet for which a + b + c = 1000 is ("
                    + a + "," + b + "," + c + ") and their product is " + product);
                    return;
                }
            }
        }
    }
}
