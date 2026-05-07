import java.util.*;

class Solution {
    static int[] discount, emoticon;
    static int[][] user;
    static int plus, price;
    public int[] solution(int[][] users, int[] emoticons) {
        user = users;
        emoticon = emoticons;
        discount = new int[emoticons.length];
        perm(0);
        
        int[] answer = new int[]{plus, price};
        return answer;
    }
    
    // discount 순열
    public static void perm(int depth){
        if(depth == emoticon.length){
            calc();
            return;
        }
        
        for(int i = 10; i <= 40; i+=10){
            discount[depth] = i;
            perm(depth+1);
        }
    }
    
    public static void calc(){
        int emoPlus = 0;    // 이모티콘 플러스 가입
        int total = 0;  // 이모티콘 구매 금액
        int max = 0;
        int dis = 0;
        int purchase = 0;   // 고객 구매 금액
        for(int i = 0; i < user.length;  i++){
            dis = user[i][0];
            max = user[i][1];
            purchase = 0;
            for(int j = 0; j < discount.length; j++){
                if(discount[j] >= dis){  // 구매
                    purchase += (emoticon[j]/100) * (100 - discount[j]);
                }
            }
            
            if(purchase >= max){
                emoPlus++;
            }else{
                total+=purchase;
            }
        }
        
        if(emoPlus > plus){
            plus = emoPlus;
            price = total;
        }else if(emoPlus == plus){
            if(total > price){
                price = total;
            }
        }
        
    }
}