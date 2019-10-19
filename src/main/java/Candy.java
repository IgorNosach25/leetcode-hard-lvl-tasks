import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/candy/
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * <p>
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above
 */
public class Candy {
    
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        PriorityQueue<Integer> tempRatings = new PriorityQueue<>();
        Set<Integer> mask = new HashSet<>();
        for (int curr : ratings) {
            if (!mask.contains(curr)) {
                tempRatings.add(curr);
                mask.add(curr);
            }
        }

        while (!tempRatings.isEmpty()) {
            int minWithoutCandy = tempRatings.remove();
            for (int i = 0; i < ratings.length; i++) {
                int currRating = ratings[i];
                if (currRating == minWithoutCandy) {
                    int leftIndex = i - 1;
                    int rightIndex = i + 1;
                    int leftCandy = 0;
                    int rightCandy = 0;
                    if (leftIndex >= 0) {
                        int leftRating = ratings[leftIndex];
                        leftCandy = leftRating >= currRating ? 0 : candies[leftIndex];
                    }
                    if (rightIndex < ratings.length) {
                        int rightRating = ratings[rightIndex];
                        rightCandy = rightRating >= currRating ? 0 : candies[rightIndex];
                    }
                    int max = Math.max(leftCandy, rightCandy);
                    candies[i] = max + 1;
                }
            }
        }
        int result = 0;
        for (int candy : candies) {
            result += candy;
        }
        return result;
    }
}
