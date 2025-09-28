class Solution11    {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maximumarea = 0;

        while(left < right){
            int currentarea = (right-left) * Math.min(height[right], height[left]);
            maximumarea = Math.max(maximumarea, currentarea);
            if(height[right]> height[left]){
                left++;
            }
            else{
                right--;
            }
        }
        return maximumarea;
    }

    public static void main(String[] args) {
        int[] arr =  {1,8,6,2,5,4,8,3,7};

        Solution11 soln = new Solution11();
        System.out.println(soln.maxArea(arr));
    }
}