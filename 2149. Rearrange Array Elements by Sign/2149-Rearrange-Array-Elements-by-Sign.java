//Optimal
//TC - O(N)  SC - O(N)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pi = 0;
        int ni = 1;
        for(int i = 0 ;i<n;i++)
        {
            if(nums[i]>0)
            {
                ans[pi] = nums[i];
                pi += 2; 
            }
            else
            {
                ans[ni] = nums[i];
                ni += 2;
            }
        }
        return ans;
    }
}

//Brute force 
// TC O(2N), SC 0(N) : N/2 + N/2

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int pi = 0;
        int ni = 0;

        for(int i = 0;i<n;i++)
        {
            if(nums[i]>0)
            {
                pos[pi++] = nums[i];
            }
            else
                neg[ni++] = nums[i];
        }
        for(int i = 0;i<n/2;i++)
        {
            nums[i*2] = pos[i];
            nums[i*2+1] = neg[i];
        }
        return nums;
    }
}
