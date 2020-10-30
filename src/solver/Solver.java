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

    private boolean check(int[][] sudoku, int x, int y, int value) {

        // first step: check the box
        int x0 = ((int) x / 3) * 3;
        int y0 = ((int) y / 3) * 3;
        for (int i = x0; i < x0 + 3; i++) {
            for (int j = y0; j < y0 + 3; j++) {
                if (sudoku[x][y] == value)
                    return false;
            }
        }

        // second step: check the horizontal
        for (int horizontal = 0; horizontal < 9; horizontal++) {
            if (sudoku[horizontal][y] == value)
                return false;
        }
        // third step: check the vertical
        for (int vertical = 0; value < 9; vertical++) {
            if (sudoku[x][vertical] == value)
                return false;
        }
        return true;
    }

    /**
     * return the next free spot of the sudoku
     * 
     * @param sudoku
     * @return
     */
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
