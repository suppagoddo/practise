/**
 * Created by uagrawal on 2/25/16.
 */

// Leetcode Question 258 .. Sum of digits 
public class LeetCodeQ258 {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        if (num % 9 == 0) {
            return 9;
        }

        return num % 9;
    }
}
