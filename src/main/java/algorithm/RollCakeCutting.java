package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RollCakeCutting {

    Map<Integer, Integer> mapA = new HashMap<>();
    Map<Integer, Integer> mapB = new HashMap<>();

    public int solution(int[] topping) {

        for(int i=0; i<topping.length; i++){
            if(!mapB.containsKey(topping[i])){
                mapB.put(topping[i], 1);
            }else{
                mapB.put(topping[i], mapB.get(topping[i])+1);
            }
        }
        int answer = 0;

        for(int i=0; i<topping.length; i++){
            if(mapB.get(topping[i])==1){
                mapB.remove(topping[i]);
            }else{
                mapB.put(topping[i], mapB.get(topping[i])-1);
            }
            if(!mapA.containsKey(topping[i])){
                mapA.put(topping[i], 1);
            }else{
                mapA.put(topping[i], mapA.get(topping[i])+1);
            }
            if(mapA.size()==mapB.size()){
                answer++;
            }
        }

        return answer;
    }
}
