/*
Permutation means n! ways to write the given number so next permutation means the next one in order.
ex - [3 1 2] will have [1 2 3] [1 3 2] [2 1 3] [2 3 1] [3 1 2] [3 2 1]

OPTIMAL : TC O(3N) O(1)

EX - [2 1 5 4 3 0 0]
1. Longer Prefix Match - find breakpoint where the graph is declining from back [2 1 | 5 4 3 0 0]
2. Find > 1 but smallest one so you stay close [2 3 _ _ _ _ _]
3. Try to place remaining elements in sorted array so you get the next permutation [2 3 0 0 1 4 5]
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: Find the break point (first index from right where nums[i] < nums[i + 1])
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        // Step 2: If no break point, array is in descending order, so reverse to get smallest permutation
        if (index == -1) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            return;
        }
        // Step 3: Find the next greater element to the right of break point and swap
        for (int i = n - 1; i >= index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        // Step 4: Reverse the suffix starting right after the break point to get the next permutation
        int start = index + 1, end = n - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

/*
Brute force TC - O(n! * n)
1. Generate all sorted permutations - recursion
2. Linear Search
3. Next per find
*/
