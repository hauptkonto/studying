package Utility;


public class MatrixHandler {

    public static void printMatrix(int[][] matrix) {
        System.out.println(matrix2str(matrix));
    }
    public static String matrix2str(int[][] matrix) {
        String str = "";
        if(matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Invalid Matrix...");;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns - 1; j++) {
                str += matrix[i][j] + ", ";
            }
            str += matrix[i][columns - 1] + "\n";
        }
        return str;
    }

    public static int[][] ones(int size) {
        return ones(size, size);
    }
    public static int[][] ones(int rows, int columns) {
        return value(rows, columns, 1);
    }
    private static int[][] value(int rows, int columns, int value) {
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = value;
            }
        }
        return matrix;
    }
    public static int[][] identity(int size) {
        int[][] identity = new int[size][size];
        for(int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }
}