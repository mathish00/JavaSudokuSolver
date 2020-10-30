public class App {
    public static void main(String[] args) throws Exception {
        Solver s = new Solver();
        int[][] mySudoku = { { 0, 9, 5, 0, 4, 6, 0, 0, 0 }, { 0, 1, 0, 3, 2, 7, 5, 0, 6 },
                { 6, 3, 2, 0, 0, 0, 8, 0, 0 }, { 0, 0, 7, 1, 3, 8, 0, 0, 0 }, { 9, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 0, 2, 0, 9, 5, 0, 0, 6, 0 }, { 0, 0, 0, 0, 0, 0, 6, 1, 0 }, { 4, 0, 3, 0, 0, 5, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 9, 0, 0, 0 } };
        s.solveSudoku(mySudoku);
        for (int[] i : mySudoku) {
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}
