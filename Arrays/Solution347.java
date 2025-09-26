
import java.util.*;

public class Solution347{

    public static int[] topKFrequentElements(int[] nums, int k){
        // initialize hashmap to store frequency of each element 
        HashMap<Integer, Integer> count = new HashMap<>();

        // initialize array frequency that stores an arraylist in each index containing 
        // the elements that occour having that count (eg. frequency 1 -> [3, 4])
        List<Integer>[] frequency = new List[nums.length+1];

        // fill frequency with arraylist
        for(int i = 0;i<frequency.length;i++){
            frequency[i] = new ArrayList<>();
        }

        // add the elements of nums and their count in hashmap
        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0) +1);
        }

        // prepare bucketsort array
        // if a number appears 3 times, it is stored in frequency[3]
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            frequency[entry.getValue()].add(entry.getKey());
        }

        // System.out.println(Arrays.toString(frequency));

        // result array
        int[] res = new int[k]; //since we are only gonna be storing top k values
        int index = 0;

        // iterate from the last value. since frequency[]'s index has count of element as index, 
        // coming from the last value will give us the elements that may have the highest
        // count first
        for(int i = frequency.length-1;i>0 && index < k;i--){
            for(int n: frequency[i]){
                res[index++] = n;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequentElements(new int[]{4, 4, 1, 1, 1, 2}, 2)));
        // [1, 4] 
    }
}