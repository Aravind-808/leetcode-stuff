import java.util.*;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i = 0, j =1;
        Arrays.sort(nums);


        List<List<Integer>> res = new ArrayList<>();


        for(i = 0; i<nums.length-3;i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            for(j = i+1;j < nums.length-2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum < target){
                        k++;
                    }
                    else if(sum > target){
                        l--;
                    }
                    else if(sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return res;


    }
}
