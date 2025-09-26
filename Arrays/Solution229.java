import java.util.*;

class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num: nums){ // {2:2} ----> 5
            count.put(num, count.getOrDefault(num, 0)+1);

            if(count.size() > 2){
                HashMap<Integer, Integer> newcount = new HashMap<>();

                for(Map.Entry<Integer, Integer> entry: count.entrySet()){
                    if(entry.getValue() > 1){
                        newcount.put(entry.getKey(), entry.getValue()-1);
                    }
                }
                count = newcount;
                System.out.println(count);
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int key: count.keySet()){
            int freq = 0;

            for(int num: nums){
                if(num==key) freq++;
            }

            if(freq > nums.length/3){
                res.add(key);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution229 sol = new Solution229();
        int[] nums = {3,2,3};
        System.out.println(sol.majorityElement(nums));
    }
}