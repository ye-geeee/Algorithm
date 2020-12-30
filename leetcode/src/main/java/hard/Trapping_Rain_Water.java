package hard;

/* https://www.youtube.com/watch?v=HmBbcDiJapY */
public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(new Solution().trap(height));
    }

    static class Solution {
        public int trap(int[] height) {
            if (height.length == 0) return 0;

            int res = 0;

            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];

            maxLeft[0] = height[0];
            maxRight[height.length - 1] = height[height.length - 1];

            for (int i = 1; i < height.length; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
                maxRight[height.length - 1 - i] = Math.max(maxRight[height.length - i], height[height.length - 1 - i]);
            }

            for (int i = 0; i < height.length; i++) {
                res += Math.min(maxLeft[i], maxRight[i]) - height[i];
            }

            return res;
        }
    }
}
