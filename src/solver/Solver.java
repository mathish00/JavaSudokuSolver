package solver;

public class Solver {

    public boolean solveSudoku(int[][] sudoku) {
        int[] spot = nextSpot(sudoku);
        if (spot == null)
            return true;
        int x = spot[0];
        int y = spot[1];
        for (int value = 1; value < 10; value++) {
            if (check(sudoku, x, y, value)) {
                sudoku[x][y] = value;
                if (solveSudoku(sudoku))
                    return true;
                sudoku[x][y] = 0;
            }
        }
        return false;
    }

    /**
     * determine the position of the coordinate (x, y) in the 3x3 box
     * 
     * @param x
     * @param y
     * @return
     */
    public String getPos(int x, int y) {
        String pos = "";
        if (y % 3 == 0)
            pos += "bottom";
        else if (y % 3 == 1)
            pos += "mid";
        else
            pos += "top";
        if (x % 3 == 0)
            pos += "left";
        else if (x % 3 == 1)
            pos += "mid";
        else
            pos += "right";
        return pos;
    }

    private boolean check(int[][] sudoku, int x, int y, int value) {

        // first step: check the box
        String pos = getPos(x, y);
        if (pos.equals("bottomleft") && (sudoku[x + 1][y] == value || sudoku[x + 2][y] == value
                || sudoku[x][y + 1] == value || sudoku[x + 1][y + 1] == value || sudoku[x + 2][y + 1] == value
                || sudoku[x][y + 2] == value || sudoku[x + 1][y + 2] == value || sudoku[x + 2][y + 2] == value))
            return false;
        if (pos.equals("bottommid") && (sudoku[x + 1][y] == value || sudoku[x - 1][y] == value
                || sudoku[x][y + 1] == value || sudoku[x + 1][y + 1] == value || sudoku[x - 1][y + 1] == value
                || sudoku[x][y + 2] == value || sudoku[x + 1][y + 2] == value || sudoku[x - 1][y + 2] == value))
            return false;
        if (pos.equals("bottomright") && (sudoku[x - 1][y] == value || sudoku[x - 2][y] == value
                || sudoku[x][y + 1] == value || sudoku[x - 1][y + 1] == value || sudoku[x - 2][y + 1] == value
                || sudoku[x][y + 2] == value || sudoku[x - 1][y + 2] == value || sudoku[x - 2][y + 2] == value))
            return false;
        if (pos.equals("midleft") && (sudoku[x + 1][y] == value || sudoku[x + 2][y] == value
                || sudoku[x][y + 1] == value || sudoku[x + 1][y + 1] == value || sudoku[x + 2][y + 1] == value
                || sudoku[x][y - 1] == value || sudoku[x + 1][y - 1] == value || sudoku[x + 2][y - 1] == value))
            return false;
        if (pos.equals("midmid") && (sudoku[x + 1][y] == value || sudoku[x - 1][y] == value || sudoku[x][y + 1] == value
                || sudoku[x + 1][y + 1] == value || sudoku[x - 1][y + 1] == value || sudoku[x][y - 1] == value
                || sudoku[x + 1][y - 1] == value || sudoku[x - 1][y - 1] == value))
            return false;
        if (pos.equals("midright") && (sudoku[x - 1][y] == value || sudoku[x - 2][y] == value
                || sudoku[x][y + 1] == value || sudoku[x - 1][y + 1] == value || sudoku[x - 2][y + 1] == value
                || sudoku[x][y - 1] == value || sudoku[x - 1][y - 1] == value || sudoku[x - 2][y - 1] == value))
            return false;
        if (pos.equals("topleft") && (sudoku[x + 1][y] == value || sudoku[x + 2][y] == value
                || sudoku[x][y - 1] == value || sudoku[x + 1][y - 1] == value || sudoku[x + 2][y - 1] == value
                || sudoku[x][y - 2] == value || sudoku[x + 1][y - 2] == value || sudoku[x + 2][y - 2] == value))
            return false;
        if (pos.equals("topmid") && (sudoku[x + 1][y] == value || sudoku[x - 1][y] == value || sudoku[x][y - 1] == value
                || sudoku[x + 1][y - 1] == value || sudoku[x - 1][y - 1] == value || sudoku[x][y - 2] == value
                || sudoku[x + 1][y - 2] == value || sudoku[x - 1][y - 2] == value))
            return false;
        if (pos.equals("topright") && (sudoku[x - 1][y] == value || sudoku[x - 2][y] == value
                || sudoku[x][y - 1] == value || sudoku[x - 1][y - 1] == value || sudoku[x - 2][y - 1] == value
                || sudoku[x][y - 2] == value || sudoku[x - 1][y - 2] == value || sudoku[x - 2][y - 2] == value))
            return false;
        // second step: check the horizontal
        for (int rightIter = x + 1; rightIter < 9; rightIter++) {
            if (sudoku[rightIter][y] == value)
                return false;
        }
        for (int leftIter = 0; leftIter < x; leftIter++) {
            if (sudoku[leftIter][y] == value)
                return false;
        }
        // third step: check the vertical
        for (int upwardsIter = y + 1; upwardsIter < 9; upwardsIter++) {
            if (sudoku[x][upwardsIter] == value)
                return false;
        }
        for (int downwardsIter = x + 1; downwardsIter < 9; downwardsIter++) {
            if (sudoku[x][downwardsIter] == value)
                return false;
        }
        return true;
    }

    private int[] nextSpot(int[][] sudoku) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (sudoku[x][y] == 0) {
                    return new int[] { x, y };
                }
            }
        }
        return null;
    }
}
