import java.util.Random;

public class MatrixManipulation {
    public static void main(String[] args) {
        Random rand = new Random();
        
        int rows = 3, cols = 3;
        int[][] matrix1 = createRandomMatrix(rows, cols, rand);
        int[][] matrix2 = createRandomMatrix(rows, cols, rand);
        
        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);
        
        System.out.println("Addition of Matrices:");
        displayMatrix(addMatrices(matrix1, matrix2));
        
        System.out.println("Subtraction of Matrices:");
        displayMatrix(subtractMatrices(matrix1, matrix2));
        
        System.out.println("Multiplication of Matrices:");
        displayMatrix(multiplyMatrices(matrix1, matrix2));
        
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(matrix1));
        
        System.out.println("Determinant of Matrix 1:");
        System.out.println(findDeterminant(matrix1));
        
        System.out.println("Inverse of Matrix 1:");
        displayMatrix(inverseMatrix(matrix1));
    }
    
    public static int[][] createRandomMatrix(int rows, int cols, Random rand) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10) + 1; // Random values between 1 and 10
            }
        }
        return matrix;
    }
    
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        return result;
    }
    
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        return result;
    }
    
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix2[0].length;
        int common = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < common; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return result;
    }
    
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
    
    public static int findDeterminant(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        if (rows == 2 && cols == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (rows == 3 && cols == 3) {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
                   matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
                   matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        return 0;
    }
    
    public static int[][] inverseMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        if (rows == 2 && cols == 2) {
            int det = findDeterminant(matrix);
            if (det == 0) {
                System.out.println("Inverse does not exist.");
                return null;
            }
            int[][] result = new int[2][2];
            result[0][0] = matrix[1][1];
            result[0][1] = -matrix[0][1];
            result[1][0] = -matrix[1][0];
            result[1][1] = matrix[0][0];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    result[i][j] /= det;
                }
            }
            return result;
        } else if (rows == 3 && cols == 3) {
            int det = findDeterminant(matrix);
            if (det == 0) {
                System.out.println("Inverse does not exist.");
                return null;
            }
            int[][] result = new int[3][3];
            result[0][0] = matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1];
            result[0][1] = -(matrix[0][1] * matrix[2][2] - matrix[0][2] * matrix[2][1]);
            result[0][2] = matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1];
            result[1][0] = -(matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
            result[1][1] = matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0];
            result[1][2] = -(matrix[0][0] * matrix[1][2] - matrix[0][2] * matrix[1][0]);
            result[2][0] = matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0];
            result[2][1] = -(matrix[0][0] * matrix[2][1] - matrix[0][1] * matrix[2][0]);
            result[2][2] = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] /= det;
                }
            }
            return result;
        }
        return null;
    }
    
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
