package 代码随想录.数组.移除元素;

/**
 * 移除元素 Leetcode24 <a href="https://leetcode.cn/problems/remove-element/">
 *
 * @author phix
 * @date 2023/10/14
 */
public class Solution {

    public static void main(String[] args) {
        int res1 = removeElement(new int[]{3, 2, 2, 3}, 3);
        if (res1 != 2) {
            throw new RuntimeException("测试用例异常,返回值应为2，实际为" + res1);
        }
        int res2 = removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        if (res2 != 5) {
            throw new RuntimeException("测试用例异常,返回值应为5，实际为" + res2);
        }
        System.out.println("移除元素测试通过");
    }

    /**
     * 双指针
     * 空间复杂度O(1) 无额外的内存空间申请
     * 时间复杂度O(n) 进行了N次的数组读取操作和赋值操作
     *
     * @param nums
     * @param val
     * @return int
     */
    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast++;
                continue;
            }
            nums[slow++] = nums[fast++];
        }
        return slow;
    }
}
