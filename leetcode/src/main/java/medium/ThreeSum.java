package medium;

import java.util.*;
import java.util.stream.Stream;

public class ThreeSum {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return Collections.EMPTY_LIST;

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                res.add(List.of(0, 0, 0));
                return res;
            }

            for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
                if (i != 0 && nums[i] == nums[i - 1])
                    continue;

                int front = i + 1;
                int back = nums.length - 1;
                int findnum = nums[i] * (-1);

                while(front < back) {
                    int sum = nums[front] + nums[back];
                    if (sum == findnum) {
                        res.add(List.of(nums[i], nums[front++], nums[back--]));

                        while(front < nums.length && nums[front] == nums[front - 1])
                            front++;
                        while(back > i && nums[back] == nums[back + 1])
                            back--;
                    }
                    else if (sum < findnum) {
                        front++;
                    }
                    else {
                        back--;
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, -2};
        List<List<Integer>> ans = new Solution().threeSum(nums);

        return;
    }
}
