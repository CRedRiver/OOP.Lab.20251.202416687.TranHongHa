import java.util.Scanner;
public class Sum_Dif_Pro_Quo {
    public static double sum(double a, double b){
        return a + b;
    }
    public static double dif(double a, double b){
        return a - b;
    }
    public static double product(double a, double b){
        return a*b;
    }
    public static double quotient(double a, double b){
        return a/b;
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double Num1 = input.nextDouble();
        double Num2 = input.nextDouble();
        input.close();
        double sum = sum(Num1, Num2);
        double dif = dif(Num1, Num2);
        double pro = product(Num1, Num2);
        double quo = quotient(Num1, Num2);
        System.out.println(sum);
        System.out.println(dif);
        System.out.println(pro);
        System.out.println(quo);
    }
}
