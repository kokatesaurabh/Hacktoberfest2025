/*
Problem Statement: Given a binary array nums, return the maximum number of consecutive 1's in the array.
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class ConsecutiveOnes {
    
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,0,1,1,1};
        System.out.println("Max consecutive ones: " + findMaxConsecutiveOnes(nums1)); // Output: 3

        int[] nums2 = {1,0,1,1,0,1};
        System.out.println("Max consecutive ones: " + findMaxConsecutiveOnes(nums2)); // Output: 2
    }
}
