package 代码随想录.数组.长度最小的子数组;

/**
 * 长度最小的子数组 209 <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">
 *
 * @author Administrator
 * @date 2023/10/15
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(new int[]{2, 3, 1, 2, 4, 3}, 7));
        System.out.println(minSubArrayLen(new int[]{1, 4, 4}, 4));
        System.out.println(minSubArrayLen(new int[]{1, 1, 1, 1, 1, 1, 1}, 11));
    }


    /**
     * 实现思路为滑动窗口，当元素和满足大于等于target值时，循环遍历至最小
     *
     * @param nums
     * @param target
     * @return int
     */
    public static int minSubArrayLen(int[] nums, int target) {
        int slow = 0;
        int fast = 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (fast < len) {
            sum += nums[fast++];
            while (sum >= target) {
                res = Math.min(res, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
