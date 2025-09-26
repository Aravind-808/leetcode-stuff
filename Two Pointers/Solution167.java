import java.util.Arrays;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int j = 0, k = numbers.length-1;


        while(j < k){
            if(numbers[j] + numbers[k] == target){
                return new int[]{j+1, k+1};
            }
            if(numbers[j] + numbers[k] < target){
                j++;
            }
            else{
                k--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution167 soln = new Solution167();
        int[]  arr = {1,2,3,5,6,7,9,10,11};

        System.out.println(Arrays.toString(soln.twoSum(arr, 12)));
    }
}
