package 代码随想录.数组.螺旋矩阵II;

import java.util.Arrays;

/**
 * 螺旋矩阵II Leetcode59 <a href="https://leetcode.cn/problems/spiral-matrix-ii/">
 *
 * @author phix
 * @date 2023/10/15
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(9)));
    }

    /**
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param n
     * @return {@link int[][]}
     */
    public static int[][] generateMatrix(int n) {
        int up = 0;
        int left = 0;
        int down = n;
        int right = n;
        int[][] matrix = new int[n][n];
        int k = 1;
        while (up <= down || left <= right) {
            for (int i = left; i < right; i++) {
                matrix[up][i] = k++;
            }
            up++;
            for (int i = up; i < down; i++) {
                matrix[i][right - 1] = k++;
            }
            right--;
            for (int i = right - 1;i >= left; i--) {
                matrix[down - 1][i] = k++;
            }
            down--;
            for (int i = down - 1; i >= up; i--) {
                matrix[i][left] = k++;
            }
            left++;
        }
        return matrix;
    }
}
