class Solution42 {
    public int trap(int[] height) {
        // two pointers starting from left and right ends
        int l = 0, r = height.length-1;

        // keep track of max height seen so far from both sides
        int leftmax = height[l], rightmax = height[r];

        // total trapped water units
        int units = 0;

        // move pointers towards each other
        while(l < r){
            // if left side max is smaller, process left side
            if(leftmax < rightmax){
                l++; // move left pointer
                leftmax = Math.max(leftmax, height[l]); // update left max
                units += leftmax - height[l]; // water trapped at this position
            }
            // otherwise process right side
            else{
                r--; // move right pointer
                rightmax = Math.max(rightmax, height[r]); // update right max
                units += rightmax - height[r]; // water trapped at this position
            }
        }
        return units; // return total trapped water
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        Solution42 soln = new Solution42();
        System.out.println(soln.trap(arr)); // should print 6
    }
}