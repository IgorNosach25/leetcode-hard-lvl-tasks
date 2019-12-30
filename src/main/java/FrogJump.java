package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * <p>
 * Note:
 * <p>
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 * <p>
 * [0,1,3,5,6,8,12,17]
 * <p>
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * <p>
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * <p>
 * [0,1,2,3,4,8,9,11]
 * <p>
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 */

public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones.length == 2 && stones[1] - stones[0] <= 1) return true;
        else if (stones.length == 2) return false;
        Map<Integer, Set<Integer>> previousWays = new HashMap<>();
        Set<Integer> firstJump = new HashSet<>();
        firstJump.add(1);
        previousWays.put(0, firstJump);
        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];
            Set<Integer> result = new HashSet<>();
            for (int previousStoneIndex = i - 1; previousStoneIndex >= 0; previousStoneIndex--) {
                int previousStone = stones[previousStoneIndex];
                Set<Integer> ways = previousWays.get(previousStoneIndex);
                if (ways.size() > 0) {
                    int difference = currentStone - previousStone;
                    if (ways.contains(difference - 1) || ways.contains(difference + 1)
                            || ways.contains(difference)) {
                        result.add(difference);
                    }
                }
                previousWays.put(i, result);
            }
        }
        return previousWays.get(stones.length - 1) != null && previousWays.get(stones.length - 1).size() > 0;
    }
}
