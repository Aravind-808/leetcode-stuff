class Solution189 {
    public static void reverse(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        // rev 0 to nums.length-1 7 6 5 4 3 2 1
        // rev 0 to k-1 -> 5 6 7
        // rev k to nums.length-1 -> 1 2 3 4
        // result -> 5 6 7 1 2 3 4


        k%=nums.length; // if k = nums.length there is no point reversing
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}
