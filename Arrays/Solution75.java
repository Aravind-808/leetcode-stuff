
import java.util.Arrays;

public class Solution75 {
    public static void sortColors(int[] nums) {
        int i = 0, l =0, r = nums.length-1;

        // 2 pointer
        while(i<=r){
            // single pass, move 0 to left, leave 1 in middle and move 2 to the right
            if(nums[i]==0){
                swap(nums, l, i); // move 0 to left
                l++;
                i++;
            }

            else if(nums[i]==1){
                i++; // leave 1 as it is
            }
            else{
                swap(nums, r, i); // move 2 to the right.
                r--;
            }
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums)); // [0,0,1,1,2,2]
    }
}
