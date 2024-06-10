public class EightQueensCode {
    //无论如何 八皇后一定要搞明白 这个是最基础的 不学会 暴力都写不好
    static final int SIZE = 8;
    private int[] queens = new int[SIZE];

    private static void print(int[] queens) {
        System.out.print("[");
        for(int q:queens)
            System.out.print(q + " ");
        System.out.println("]");
    }

    /** Search for a solution */
    private boolean search() {
// k - 1 indicates the number of queens placed so far
// We are looking for a position in the kth row to place a queen
        int k = 0;
        while (k >= 0 && k < SIZE) {
// Find a position to place a queen in the kth row
            int j = findPosition(k);
            if (j < 0) {
                queens[k] = -1;
                k--; // back track to the previous row
            } else {
                queens[k] = j;
                k++;
            }
        }
        if (k == -1)
            return false; // No solution
        else
            return true; // A solution is found
    }
    public int findPosition(int k) {
        int start = queens[k] + 1; // Search for a new placement
        for (int j = start; j < SIZE; j++) {
            if (isValid(k, j))
                return j; // (k, j) is the place to put the queen now
        }
        return -1;
    }
    /** Return true if a queen can be placed at (row, column) */
    public boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++)
            if (queens[row - i] == column // Check column
                    || queens[row - i] == column - i // Check upleft diagonal
                    || queens[row - i] == column + i) // Check upright diagonal
                return false; // There is a conflict
        return true; // No conflict
    }
}
