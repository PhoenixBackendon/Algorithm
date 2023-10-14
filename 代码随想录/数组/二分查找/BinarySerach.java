package 代码随想录.数组.二分查找;

import java.lang.RuntimeException;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int res = binarySearch(nums,9);
        if (res != 4) {
            throw new RuntimeException("测试用例异常,返回值应为4，实际为" + res);
        }
        res == binarySearch(nums,2);
        if (res != -1) {
            throw new RuntimeException("测试用例异常,返回值应为-1，实际为" + res);
        }
    }

    public static int binarySearch(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        for left < right {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}