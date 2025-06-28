/*
TC O(n log k) SC O(k)
Approach: 
Store (value, index) for each element to track original positions.
1. Use a Min Heap of size k to keep track of k largest elements.
2. If heap size exceeds k, remove the smallest element from the heap.
3. After processing all elements, heap contains top k largest elements.
4. Sort these k elements by their original index to maintain order.
5. Extract only the values to form the final subsequence.
*/


class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        // Min Heap: stores {value, index}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Step 1: Push each element with its index into the heap
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[] {nums[i], i});  // {value, index}

            // Step 2: If heap size exceeds k, remove smallest element
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove min element (top of min heap)
            }
        }

        // Step 3: Heap now contains k largest elements but in random order
        List<int[]> list = new ArrayList<>(minHeap);

        // Step 4: Sort selected elements by original index to maintain subsequence order
        Collections.sort(list, (a, b) -> a[1] - b[1]);

        // Step 5: Build the final result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];  // Extract values
        }

        return result;
    }
}
