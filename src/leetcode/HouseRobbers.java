/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
package leetcode;

public class HouseRobbers {
    public static void main(String[] args) {
       int[] nums = {2,7,9,3,1};
       Solution sol = new Solution();
        System.out.println(sol.rob(nums));
    }
}
class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if(size==1)
            return nums[0];
        if(size==2)
            return Math.max(nums[1], nums[0]);
        int dp[]=new int[size+1];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],dp[1]);
        int c=2;
        for (int i = 2; i < size ; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[size-1];
    }
}