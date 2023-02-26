package algorithm;

public class TwoDimensionCoinFlipper {

    int[][] start;
    int[][] end;
    int row;
    int col;
    int min;

    public int solution(int[][] beginning, int[][] target) {

        start = beginning;
        end = target;
        row = start.length;
        col = start[0].length;
        min = 99999;

        canUpper(0, 0, 0);
        return min==99999 ? -1 : min;
    }

    public void findAnswer(int count){
        for(int x=0; x<row; x++){
            for(int y=0; y<col; y++){
                if(start[x][y]!=end[x][y]){
                    return;
                }
            }
        }
        min = count<min ? count : min;
    }

    public void rowUpper(int x){
        for(int y=0; y<col; y++){
            start[x][y] = start[x][y]==0 ? 1 : 0;
        }
    }

    public void colUpper(int y){
        for(int x=0; x<row; x++){
            start[x][y] = start[x][y]==0 ? 1 : 0;
        }
    }

    public void canUpper(int x, int y, int count){

        if(x==row&&y==col){
            findAnswer(count);
            return;

        }else if(x<row&&y==col){
            rowUpper(x);
            canUpper(x+1, y, count+1);
            rowUpper(x);
            canUpper(x+1, y, count);
        }
        else if(x==row&&y<col){
            colUpper(y);
            canUpper(x, y+1, count+1);
            colUpper(y);
            canUpper(x, y+1, count);
        }else{
            rowUpper(x);
            colUpper(y);
            canUpper(x+1, y+1, count+2);
            colUpper(y);
            canUpper(x+1, y+1, count+1);
            rowUpper(x);
            colUpper(y);
            canUpper(x+1, y+1, count+1);
            colUpper(y);
            canUpper(x+1, y+1, count);
        }
    }
}
