import java.util.Arrays;

public class Solution912 {

    // merge logic for merge sort algorithm
    static int[] merge(int[] arr, int l,int m,int r){
            int[] left = Arrays.copyOfRange(arr, l, m+1);
            int[] right = Arrays.copyOfRange(arr, m+1, r+1);

            int i = l, j = 0, k = 0;

            // compare left and right indices of divided array replace it in main arr.
            while(j < left.length && k < right.length){
                if(left[j] <=right[k]){
                    arr[i] = left[j];
                    j++;
                }
                else{
                    arr[i] = right[k];
                    k++;
                }
                i++;
            }

            // add residual elements
            while(j<left.length){
                arr[i] = left[j];
                j++;
                i++;
            }
            
            while(k<right.length){
                arr[i] = right[k];
                k++;
                i++;
            }

            return arr;
    }
    
    // mergesort recursional algorithm that divides arr recursively and sorts it.

    static int[] mergesort(int[] arr,int l,int r){
        if(l==r){
            return arr;
        }
        int m = (l+r)/2;

        mergesort(arr, l, m);
        mergesort(arr, m+1, r);
        merge(arr, l, m, r);

        return arr;
    }

    // main method that calls the mergesort function after initializing l and r.
    public static int[] sortArray(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        return mergesort(nums, l, r);
    }

    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};
        int[] res = sortArray(arr);

        System.out.println(Arrays.toString(res)); // {0,0,1,1,2,5}
    }
}
