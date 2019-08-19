package Problems.Top50.group30;

import Utility.IProblem;
import Utility.MatrixHandler;

/**
 * Matrix multiplication.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N37_MatrixMult implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[][] A = {{1,1, 1},
                {1,1, 1}};
        int[][] B = {{1},
                {1},
                {1}};
        MatrixHandler.printMatrix(A);
        MatrixHandler.printMatrix(B);
        int[][] result = multiply(A, B);
        MatrixHandler.printMatrix(result);
    }

    /**
     * A [2x3] * B [3x1] = C [2x1]
     *
     */
    private int[][] multiply(int[][] A, int[][] B) {
        if(A[0].length != B.length) {
            System.err.println("Incompatible multiplication");
        }
        int rows = A.length;
        int columns = B[0].length;
        int inner = B.length;
        int[][] result = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                for(int k = 0; k < inner; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

}
