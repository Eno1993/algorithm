package algorithm;

import java.util.Arrays;

public class SeesawPartner {
    public long solution(int[] weights) {

        Arrays.sort(weights);
        int[] count = new int[weights.length];
        long answer = 0;

        for(int i=0; i<weights.length-1; i++){

            if(1<=i&&weights[i-1]==weights[i]){
                if(0<count[i-1]){
                    count[i] = count[i-1]-1;
                }
                answer += count[i];
                continue;
            }
            for(int j=i+1; j<weights.length; j++){

                if(weights[i]==weights[j]||
                        //weights[i]*2==weights[j]||
                        weights[i]*2==weights[j]*3||
                        weights[i]*2==weights[j]*4||
                        //weights[i]*3==weights[j]||
                        weights[i]*3==weights[j]*2||
                        weights[i]*3==weights[j]*4||
                        //weights[i]*4==weights[j]||
                        weights[i]*4==weights[j]*2||
                        weights[i]*4==weights[j]*3){
                    count[i] += 1;
                }
            }
            answer += count[i];
        }
        return answer;
    }

}
