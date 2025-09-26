class Solution680 {
    public boolean isPalin(String s){
        int left = 0, right = s.length() -1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                String leftskip = s.substring(l+1, r+1);
                String rightskip = s.substring(l, r);

                return isPalin(leftskip) || isPalin(rightskip); 
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution680 soln = new Solution680();

        String s = "abdca";
        System.out.println(soln.validPalindrome(s));
    }
}