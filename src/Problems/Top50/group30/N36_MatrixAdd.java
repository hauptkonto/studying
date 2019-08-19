package Problems.Top50.group30;


import Utility.IProblem;
import Utility.MatrixHandler;

/**
 * Adding two matrices in Java.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N36_MatrixAdd implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[][] m1 = MatrixHandler.ones(3, 4);
        int[][] m2 = MatrixHandler.ones(3, 4);
        m1[2][3] = 8;
        System.out.println("Matrix 1:");
        MatrixHandler.printMatrix(m1);

        m2[2][1] = 5;
        System.out.println("Matrix 2:");
        MatrixHandler.printMatrix(m2);
        int[][] result = addMatrixes(m1, m2);
        MatrixHandler.printMatrix(result);
    }

    public int[][] addMatrixes(int[][] m1, int[][] m2) {
        // Validate data
        if(m1 == null || m2 == null) {
            return m1;
        }
        if(m1.length != m2.length || m1[0].length != m2[0].length) {
            return m2;
        }

        // Perform adition
        int rows = m1.length;
        int columns = m1[0].length;
        int[][] result = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return result;
    }
}