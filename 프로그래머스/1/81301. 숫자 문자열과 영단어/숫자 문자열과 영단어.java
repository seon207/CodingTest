class Solution {
    public int solution(String s) {
        String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int answer = 0;
        
        for(int i = 0; i < arr.length; i++){
            s = s.replace(arr[i], Integer.toString(i));
        }
        
        
        return Integer.parseInt(s);
    }
}