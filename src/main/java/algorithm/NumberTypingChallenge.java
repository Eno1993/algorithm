package algorithm;

public class NumberTypingChallenge {
    int[][] arr = {
            {1,7,6,7,5,4,5,3,2,3},
            {7,1,2,4,2,3,5,4,5,6},
            {6,2,1,2,3,2,3,5,4,5},
            {7,4,2,1,5,3,2,6,5,4},
            {5,2,3,5,1,2,4,2,3,5},
            {4,3,2,3,2,1,2,3,2,3},
            {5,5,3,2,4,2,1,5,3,2},
            {3,4,5,6,2,3,5,1,2,4},
            {2,5,4,5,3,2,3,2,1,2},
            {3,6,5,4,5,3,2,4,2,1}
    };
    int[][][] record;
    String str;
    Integer MAX = 999999;

    public int dp(int index, int left, int right){

        if(index==str.length()){
            return 0;
        }

        if(record[index][left][right]!=MAX){
            return record[index][left][right];
        }

        if(left==right){
            return MAX;
        }

        int target = str.charAt(index)-'0';
        int minNum = Math.min(
                dp(index+1, target, right)+arr[left][target],
                dp(index+1, left, target)+arr[right][target]);
        record[index][left][right] = minNum;
        return minNum;
    }

    public int solution(String numbers) {
        str = numbers;
        record = new int[numbers.length()][10][10];
        for(int l=0; l<numbers.length(); l++){
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    record[l][i][j] = MAX;
                }
            }
        }

        return dp(0, 4, 6);

    }
}
