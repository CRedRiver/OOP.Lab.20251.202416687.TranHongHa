import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] my_array1 = {1954, 1538, 2434, 2350, 1634};

        System.out.println("Original array: " + Arrays.toString(my_array1));

        Arrays.sort(my_array1);
        System.out.println("Sorted array: " + Arrays.toString(my_array1));

        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }

        double average = (double) sum / my_array1.length;

        System.out.println("Sum of array elements = " + sum);
        System.out.printf("Average value of array elements = %.2f%n", average);
    }
}
