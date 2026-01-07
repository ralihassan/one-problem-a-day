class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        
        int max = 0;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<n; i++){
            int start = i;

            while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] popped = stack.pop();
                int height = popped[0];
                int index = popped[1];

                max = Math.max(max, height * (i - index));
                start = index;
            }

            stack.push(new int[]{heights[i], start});
        }

        while (!stack.isEmpty()) {
            int height = stack.peek()[0];
            int index = stack.pop()[1];
            max = Math.max(max, height* (n-index));
        }
        
        return max;
    }
}