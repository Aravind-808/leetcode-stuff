class Solution125 {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());

        int l = 0, r = sb.length()-1;

        if(sb.length()==1) return false;
        while(l<r){
            if(sb.charAt(l) == sb.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    
    }
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

}