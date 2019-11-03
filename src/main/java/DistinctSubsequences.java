package main.java;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence
 * of "ABCDE" while "AEC" is not).Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        int[][] temp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < temp[0].length; i++) {
            temp[0][i] = 1;
        }
        for (int i = 1; i < temp.length; i++) {
            for (int k = 1; k < temp[0].length; k++) {
                int curr;
                if (s.charAt(k - 1) == t.charAt(i - 1)) {
                    curr = temp[i - 1][k - 1] + temp[i][k - 1];
                } else {
                    curr = temp[i][k - 1];
                }
                temp[i][k] = curr;
            }
        }
        return temp[temp.length - 1][temp[0].length - 1];
    }
}

