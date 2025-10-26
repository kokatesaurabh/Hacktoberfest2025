// Problem: Longest Substring Without Repeating Characters
// Time Complexity: O(n)
// Space Complexity: O(min(n, charset))
// Example Input: s = "abcabcbb"
// Example Output: 3

import java.util.HashSet;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int maxLen = 0, left = 0, right = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + lengthOfLongestSubstring(s3));
    }
}
