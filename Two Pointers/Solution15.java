import java.util.*;
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> alltriplets = new ArrayList<List<Integer>>();
        int i = 0, j = 1, k = nums.length-1;
        int target = 0;
        Arrays.sort(nums);


        for(i = 0;i<nums.length;i++){
        if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }    
        j = i+1;
        k = nums.length-1;
        while(j<k){
           
            int sum = nums[i] + nums[j] + nums[k];
            if(sum==target){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[j]);
                triplet.add(nums[k]);
                alltriplets.add(triplet);
                j++;k--;
                while(j<k && nums[j] == nums[j-1]) j++;
                while(j<k && nums[k] == nums[k+1]) k--;
            }
            else if(sum < target){
                j++;
            }
            else if(sum > target){
                k--;
            }
        }
        }
        return alltriplets;
    }
}
