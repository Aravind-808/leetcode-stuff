import java.util.HashSet;

class Solution128 {
    public static int longestConsecutive(int[] nums) {

        // since there might be repeating numbers in nums,
        // we are putting unique nums in a set
        HashSet<Integer> numset = new HashSet<>();

        for(int num: nums){
            numset.add(num);
        }
        
        // length can be used to track the current length of any sequence detected
        // longest can be used to update the max length after a sequence is exhausted
        int length = 0;
        int longest = 0;
        for(int num: numset){
            // we can identify if a number is the start of a sequence if
            // that number doesnt have any predecessor (num-1 doesnt exist in the set)
            if(!numset.contains(num-1)){
                length=0;
                // after the predecessor is identified, we can track it's sequence length
                // by checking if subsequent numbers exist

                // eg. 1+1, 1+2, 1+3.... 
                while(numset.contains(num+length)){
                    length++;
                }
                // after a sequence is broken, update the value of the longest sequence yet.
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        System.out.println(longestConsecutive(nums));
    }
}