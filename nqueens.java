import java.util.*;
class Nqueens {
    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList();
        String row = "";

        for(int i = 0; i < board.length; ++i) {
            row = " ";
            for(int j = 0; j < board.length; ++j) {
                if (board[i][j] == 'Q') {
                    row = row + "Q";
                } else {
                    row = row + ".";
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    public static boolean isSafe(int row, int col, char[][] board) {
        int r;
        for(r = 0; r < board.length; ++r) {
            if (board[row][r] == 'Q') {
                return false;
            }
        }

        for(r = 0; r < board.length; ++r) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }
        r = row;
        for(int c = col; c >= 0 && r >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        r = row;
        for(int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        r = row;
        for(int c = col; r < board.length && c >= 0; --c) {
            if (board[r][c] == 'Q') {
                return false;
            }

            ++r;
        }

        for(int c = col; c < board.length && r < board.length; r++, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        else {
            for(int row = 0; row < board.length; ++row) {
                if (isSafe(row, col, board)) {
                    board[row][col] = 'Q';
                    helper(board, allBoards, col + 1);
                    board[row][col] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> allBoards = new ArrayList();
        char[][] board = new char[n][n];
        int col = 0;
        helper(board, allBoards, col);
        System.out.println(allBoards);
    }
}
