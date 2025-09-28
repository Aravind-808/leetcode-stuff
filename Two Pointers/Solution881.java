import java.util.Arrays;

class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        int boatcount = 0;
        int left = 0, right = people.length-1;
        Arrays.sort(people);

        while(left<=right){
            int sum = people[left] + people[right];
            if(sum <=limit){
                boatcount++;
                right--;
                left++;
            }
            else if(sum > limit){
                right--;
                boatcount++;
            }
        }
        return boatcount;
    }

    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 3;

        Solution881 soln = new Solution881();
        System.out.println(soln.numRescueBoats(people, limit));
    }
}