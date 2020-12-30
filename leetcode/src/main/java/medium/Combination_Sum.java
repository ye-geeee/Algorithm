package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        /*candidates = [2,3,6,7], target = 7*/
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(new Solution().combinationSum(candidates, target));
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> queue = new ArrayList<>();
            combination(candidates, 0, target, queue, ans);
            return ans;
        }

        public void combination(int[] candidates, int index, int target,
                                                List<Integer> tempQueue, List<List<Integer>> ans) {
            if(target >= 0 && index != candidates.length) {
                if(target == 0)
                    ans.add(tempQueue);
                else {
                    List<Integer> candidateIncludedQueue = new ArrayList<>(tempQueue);
                    candidateIncludedQueue.add(candidates[index]);
                    combination(candidates, index, target - candidates[index], candidateIncludedQueue, ans);
                    combination(candidates, index + 1, target, tempQueue, ans);
                }
            }
        }
    }
}
