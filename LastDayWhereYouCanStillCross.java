
class Solution {
    int total = 0;

    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int track[][] = new int[row][col];
        total = col;

        for (int i=0; i<cells.length; i++) {
            int m = cells[i][0]-1;
            int n = cells[i][1]-1;
            if (track[m][n] == 0) {
                dfs(track, m, n);
            }
            if (total == 0) return i;
        }

        return cells.length;
    }

    private void dfs(int track[][], int i, int j) {
        int row = track.length, col = track[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || track[i][j] != 0) return;
        
        track[i][j] = 1;
        if ( i == track.length-1) total--;

        if (i < row-1 && !canReach(track, i+1, j)) {
            dfs(track, i+1, j);
        }

        if (i > 0 && !canReach(track, i-1, j)) {
            dfs(track, i-1, j);
        }

        if (j > 0 && !canReach(track, i, j-1)) {
            dfs(track, i, j-1);
        }

        if (j < col-1 && !canReach(track, i, j+1)) {
            dfs(track, i, j+1);
        }
    }

    private boolean canReach(int track[][], int i, int j) {
        int row = track.length, col = track[0].length;
        if (i == 0 && track[i][j] == 0) return true;
        return (i > 0 && track[i-1][j] == 0) ||(j < col-1 && track[i][j+1] == 0) || (i < row-1 && track[i+1][j] == 0) || (j > 0 && track[i][j-1] == 0);
    }
}

// Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]