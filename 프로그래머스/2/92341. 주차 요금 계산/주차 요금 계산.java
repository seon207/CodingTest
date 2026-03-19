import java.util.*;

class Solution {
    static HashMap<Integer, Integer> in;   
    static TreeMap<Integer, Integer> total;  

    public int[] solution(int[] fees, String[] records) {
        in = new HashMap<>();
        total = new TreeMap<>();

        for (String r : records) {
            String[] rs = r.split(" ");
            int time = convertTime(rs[0]);
            int car = Integer.parseInt(rs[1]);
            String cmd = rs[2];

            if (cmd.equals("IN")) {
                in.put(car, time);
            } else { 
                int inTime = in.remove(car);
                total.put(car, total.getOrDefault(car, 0) + (time - inTime));
            }
        }

        int endTime = convertTime("23:59");
        for (Map.Entry<Integer, Integer> entry : in.entrySet()) {
            int car = entry.getKey();
            int inTime = entry.getValue();
            total.put(car, total.getOrDefault(car, 0) + (endTime - inTime));
        }

        int[] answer = new int[total.size()];
        int idx = 0;

        for (int time : total.values()) {
            answer[idx++] = calc(time, fees);
        }

        return answer;
    }

    public static int calc(int time, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;

        int extra = time - baseTime;
        return baseFee + (int)Math.ceil((double) extra / unitTime) * unitFee;
    }

    public static int convertTime(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]) * 60;
        int min = Integer.parseInt(t[1]);
        return hour + min;
    }
}