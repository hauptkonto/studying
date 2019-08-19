package Problems.Top50.group30;

import Utility.IProblem;
import Utility.MatrixHandler;

/**
 * Transpose a matrix.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N33_MatrixTranspose implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[][] matrix =   {{ 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 0, 9, 0}};
        MatrixHandler.printMatrix(matrix);
        int[][] transposed = transpose(matrix);
        MatrixHandler.printMatrix(transposed);
    }

    private static int[][] transpose(int[][] matrix) {
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        // Inverted number of rows and columns since this is transposed.
        int[][] transposed = new int[numberOfColumns][numberOfRows];
        for(int i = 0; i < numberOfColumns; i++) {
            for(int j = 0; j < numberOfRows; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
}
