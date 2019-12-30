package main.java;

import java.util.Queue;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String input) {
        if (input == null || input.isEmpty()) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) stack.add(i);
                else max = Math.max(max, i - stack.peek());
            } else {
                stack.add(i);
            }
        }
        return max;
    }
}
