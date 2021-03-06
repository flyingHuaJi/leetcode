package Recursive;

import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 11:23 下午
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * 思路：
 * dfs:
 *
 * 五毒神掌：
 * 第二遍，2021/3/14
 * 第三遍，2021/4/8
 * 第四遍，2021/4/17
 *
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();;
        if (len == 0) {
            return res;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }

}
