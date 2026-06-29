class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows[r][d] = true 表示第 r 行已存在数字 d+1
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        // squares[s][d] = true 表示第 s 个宫格已存在数字 d+1
        boolean[][] squares = new boolean[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                
                int d = board[r][c] - '1';      // '1'-'9' → 0-8
                int s = (r / 3) * 3 + (c / 3);  // 宫格编号 0-8
                
                if (rows[r][d] || cols[c][d] || squares[s][d]) {
                    return false;
                }
                
                rows[r][d] = true;
                cols[c][d] = true;
                squares[s][d] = true;
            }
        }
        return true;
    }
}