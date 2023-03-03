package algorithm;

public class CourierDeliveryAndCollection {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long deliver = 0;
        long pickup = 0;
        long answer = 0;

        for(int i=deliveries.length-1; 0<=i; i--){
            deliver += deliveries[i];
            pickup += pickups[i];

            while(0<deliver){
                answer += 2*(i+1);
                deliver -= cap;
                pickup -= cap;
            }

            while(0<pickup){
                answer += 2*(i+1);
                deliver -= cap;
                pickup -= cap;
            }
        }

        return answer;
    }
}
