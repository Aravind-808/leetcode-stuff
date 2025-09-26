
import java.util.Arrays;

public class Solution238 {

    // the logic here is pretty straightforward
    // given nums[], create a prefix and postfix product array

    // prefix will contain cumulative product from left to right
    // postfix will contain cumulative product from right to left

    // for each element in nums, the product except self will be 
    //          prefix[i-1] * postfix[i+1]  (if 0 < i < nums.length-1 or else 1 in its place)
    // where i is the index of the current element in nums (we use i bc all 3 arrays (nums, prefix and postfix) are of same length)

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = nums.clone();
        int[] postfix = nums.clone();
        int[] res = new int[nums.length];
        for(int i = 1;i<nums.length;i++){
            prefix[i]*=prefix[i-1];
        }

        for(int i = nums.length-1;i>0;i--){
            postfix[i-1] *= postfix[i];
        }

        System.out.println(Arrays.toString(nums)+"\n"+Arrays.toString(prefix)+"\n"+Arrays.toString(postfix));

        for(int i = 0; i<nums.length;i++){
            int prefixnum = i>0?prefix[i-1]:1;
            int postfixnum = i<nums.length-1?postfix[i+1]:1;
            res[i] = prefixnum * postfixnum;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 9};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    
    }
}
