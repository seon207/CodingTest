class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        boolean flag = true;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                flag = true;
            }else if(flag){
                sb.setCharAt(i, Character.toUpperCase(c));
                flag = false;
            }
        }
        
        return sb.toString();
    }
}