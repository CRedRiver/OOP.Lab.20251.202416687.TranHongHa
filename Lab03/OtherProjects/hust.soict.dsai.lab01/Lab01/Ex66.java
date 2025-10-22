import java.util.Scanner;
import java.util.Arrays;

public class Ex66 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of two matrices:");
        System.out.print("m = ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Matrix 1:");
        double[][] mat1 = createMatrix(scanner, m, n);
        System.out.println("Matrix 2:");
        double[][] mat2 = createMatrix(scanner, m, n);
        scanner.close();

        long[][] mat_solution = addMatrix(mat1, mat2, m, n);
        printMatrixLong(mat_solution, m, n);
    }

    public static double[][] createMatrix(Scanner scanner, int m, int n){
        double[][] matrix = new double[m][n];
        for (int i = 0; i<m; i++){
            String line = scanner.nextLine();
            String[] row = line.split(" ");
            if (row.length == n){
                for (int j = 0; j<n; j++){
                    matrix[i][j] = Double.parseDouble(row[j]);
                }
            } else{
                System.out.println("Error!");
                return null;
            }
        }
        return matrix;
    }
    
    public static long[][] addMatrix(double[][] mat1, double[][] mat2, int m, int n){
        long[][] mat_res = new long[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
            mat_res[i][j] = Math.round(mat1[i][j] + mat2[i][j]);
            }
        }
        return mat_res;
    }


    public static void printMatrixLong(long[][] matrix, int m, int n){
        for (int i = 0; i < m; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
