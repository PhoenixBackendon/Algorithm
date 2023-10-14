package 代码随想录.数组.有序数组的平方;

import java.util.Arrays;

/**
 * 有序数组的平方   <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">
 *
 * @author phix
 * @date 2023/10/14
 */
public class Solution {

    public static void main(String[] args) {
        int[] res1 = sortedSquares1(new int[]{-4, -1, 0, 3, 10});
        int[] res2 = sortedSquares1(new int[]{-7, -6, -3, -2, -1});
        int[] res3 = sortedSquares1(new int[]{1, 2, 3, 18, 20});
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }

    /**
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return {@link int[]}
     */
    public static int[] sortedSquares1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // 优化方案，优化当最后一个数为负数的时候，避免查找正数导致两次O(n)操作
        if (nums[len - 1] < 0) {
            for (int i = 0; i < len; i++) {
                res[len - i - 1] = nums[i] * nums[i];
            }
            return res;
        }
        int index = 0;
        for (int num : nums) {
            if (num < 0) {
                index++;
            } else {
                break;
            }
        }
        int left = index;
        int right = index + 1;
        int i = 0;
        while (left > -1 || right < len) {
            if (left == -1) {
                res[i] = nums[right] * nums[right];
                right++;
            } else if (right == len) {
                res[i] = nums[left] * nums[left];
                left--;
            } else if (-nums[left] >= nums[right]) {
                res[i] = nums[right] * nums[right];
                right++;
            } else if (-nums[left] < nums[right]) {
                res[i] = nums[left] * nums[left];
                left--;
            }
            i++;

        }
        return res;

    }

    public static int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int left = 0;
        int right = len - 1;
        int k = 0;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare <= rightSquare) {
                res[k] = rightSquare;
                right--;
            } else {
                res[k] = leftSquare;
                left++;
            }
            k--;
        }
        return res;
    }

}
