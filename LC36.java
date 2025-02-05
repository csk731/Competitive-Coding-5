// TC: O(1)
// SC: O(1)
// Reason: In the problem there are only 81 cells, so the time complexity is O(1) and space complexity is O(1) because we are using only 3 hashmaps of size 9.


import java.util.HashMap;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        HashMap<Integer, Integer> gridMap = new HashMap<>();
        for(int i=0;i<9;i++){
            rowMap.put(i, 0);
            colMap.put(i, 0);
            gridMap.put(i, 0);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.') continue;
                int ele = ch-48;
                int boxIdx = (i/3)*3+(j/3);
                if((rowMap.get(i)&(1<<ele))!=0 || (colMap.get(j)&(1<<ele))!=0 || (gridMap.get(boxIdx)&(1<<ele))!=0) return false;
                rowMap.put(i, rowMap.get(i)^(1<<ele));
                colMap.put(j, colMap.get(j)^(1<<ele));
                gridMap.put(boxIdx, gridMap.get(boxIdx)^(1<<ele));
            }
        }
        return true;
    }
}
