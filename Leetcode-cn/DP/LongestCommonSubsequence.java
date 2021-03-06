package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/27 9:42 下午
 * https://leetcode-cn.com/problems/longest-common-subsequence
 *
 * 思路：
 * DP
 *
 * 五毒神掌：
 * 第二遍，2021/4/27
 * 第三遍，2021/6/22
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m  = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
