package demo;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(nums1,nums2));
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int[] nums = mergeArrays(nums1,nums2);
        int size = nums.length;
        for(Integer i : nums){
            System.out.print(i+" ");
        }
        if(size % 2 == 0){
            //System.out.println("here");
            return (double)(nums[size/2]+nums[(size-1)/2])/2;
        }
        else{
            return nums[size/2];
        }
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int size = l1 + l2;
        int[] nums= new int[size];
        int i=0,j=0,k=0;
        while(i<l1 && j<l2){
            if(nums1[i]<=nums2[j]){
                nums[k++] = nums1[i++];
            }
            else{
                nums[k++] = nums2[j++];
            }
        }
        if(i<l1){
            while(i<l1){
                nums[k++] = nums1[i++];
            }
        }
        if(j<l2){
            while(j<l2){
                nums[k++] = nums2[j++];
            }
        }
        return nums;
    }
}
