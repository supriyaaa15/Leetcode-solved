/*
Optimal: TC O(n) SC - O(n)
1. Insert all elements into a HashSet
2. Iterate over each element in the set
3. Start counting only from sequence starters
-If (num - 1) is not present, num is the start of a sequence
4. Count the length of consecutive numbers
-Keep checking (num + 1), (num + 2), etc., as long as they're present
5. Update the maximum sequence length found so far
6. Return the longest sequence length
*/
class Solution {
    public int longestConsecutive(int[] nums) {
    int n = nums.length;
    if(n==0) return 0;
    Set <Integer> key = new HashSet<>();
    for(int num : nums)
    {
        key.add(num);
    }
    int longest = 1;
    for(int num : key)
    {
    // Start sequence only if num - 1 is not in set (beginning of sequence)
        if (!key.contains(num - 1)) {
            int count = 1;
            int x = num;
            // Count consecutive numbers
            while (key.contains(x + 1)) {
                x = x + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
    }
    return longest;
    }    
}


/*
Better TC - O(N LOG N) SC O(1)
APPROACH :
Sort the array.

Loop through the sorted array:

If the current number is equal to the previous +1, it’s consecutive, so increase the streak.

If it’s a duplicate (i.e., equal to previous), skip it.

If not consecutive, reset the streak.
*/

import java.util.Arrays;
class Solution {
    public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int longest = 1;
    int count = 1;
    if(n == 0) return 0;
    for(int i = 1; i <n; i++)
    {
        if (nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }

        else if(nums[i] == (nums[i - 1] +1))
        {
            count++;
        }
        else count = 1;
        longest = Math.max(longest,count);
    }
    return longest;
    }    
}



//Brute force  TC O(N^2) SC O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        int longest = 1;
        for(int i = 0;i<nums.length;i++)
        {
            int x = nums[i];
            int count = 1;
            while(ls(nums,x+1))
            {
                x++;
                count += 1;
                
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    public boolean ls(int[] nums, int x)
    {
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]==x)
            {
                return true;
            }
        }
        return false;
    }
}
