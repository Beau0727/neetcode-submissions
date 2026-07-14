
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 末尾追加高度为0的哨兵
        int[] arr = new int[heights.length + 1];
        System.arraycopy(heights, 0, arr, 0, heights.length);
        
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int h = arr[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, h * (i - left - 1));
            }
            stack.push(i);
        }

        return maxArea;
    }
}