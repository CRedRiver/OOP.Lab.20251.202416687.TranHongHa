import java.util.Scanner;

public class Ex226 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("Enter 0 for linear equation;");
            System.out.println("Enter 1 for systems of linear equations;");
            System.out.println("Enter 2 for quadratic equation;");
            System.out.println("Enter your choice:");
            int choice = input.nextInt();
            input.nextLine(); 

            if (choice == 0){
                double res = linearEqSolver(input);
                if (!Double.isNaN(res)) {
                    System.out.printf("x = %.2f%n", res);
                }
                break;
            }
            else if (choice == 1){
                double[] res = systemEqsSolver(input);
                if (res != null) {
                    System.out.printf("x = %.2f, y = %.2f%n", res[0], res[1]);
                }
                break;
            }
            else if (choice == 2){
                double[] res = quadraticEqSolver(input);
                if (res != null) {
                    if (res.length == 2) {
                        System.out.printf("x1 = %.2f, x2 = %.2f%n", res[0], res[1]);
                    } else {
                        System.out.printf("x = %.2f%n", res[0]);
                    }
                }
                break;
            }
            else {
                System.out.println("Error! Try again!");
                break;
            }
        }

        input.close();
    }

    public static double linearEqSolver(Scanner input){
        System.out.println("Linear Equation (a*x + b = 0):");
        System.out.print("Enter a = ");
        String a_str = input.nextLine();
        if (a_str.isEmpty()) {
            System.out.println("Invalid input!");
            return Double.NaN;
        }
        double a = Double.parseDouble(a_str);

        if (a == 0){
            System.out.println("No solution!");
            return Double.NaN;
        }

        System.out.print("Enter b = ");
        String b_str = input.nextLine();
        if (b_str.isEmpty()) {
            System.out.println("Invalid input!");
            return Double.NaN;
        }
        double b = Double.parseDouble(b_str);

        return (-b) / a;
    }

    public static double[] systemEqsSolver(Scanner input){
        System.out.println("First equation (a1*x + b1*y = c1):");
        System.out.print("a1 = ");
        double a1 = Double.parseDouble(input.nextLine());
        System.out.print("b1 = ");
        double b1 = Double.parseDouble(input.nextLine());
        System.out.print("c1 = ");
        double c1 = Double.parseDouble(input.nextLine());

        System.out.println("Second equation (a2*x + b2*y = c2):");
        System.out.print("a2 = ");
        double a2 = Double.parseDouble(input.nextLine());
        System.out.print("b2 = ");
        double b2 = Double.parseDouble(input.nextLine());
        System.out.print("c2 = ");
        double c2 = Double.parseDouble(input.nextLine());

        double delta = a1*b2 - a2*b1;
        double delta_x = c1*b2 - c2*b1;
        double delta_y = a1*c2 - a2*c1;

        if (delta != 0) {
            double sol_x = delta_x / delta;
            double sol_y = delta_y / delta;
            return new double[]{sol_x, sol_y};
        } else {
            if (delta_x == 0 && delta_y == 0) {
                System.out.println("Infinitely many solutions!");
            } else {
                System.out.println("No solution!");
            }
            return null;
        }
    }

    public static double[] quadraticEqSolver(Scanner input){
        System.out.println("Quadratic equation (a*x^2 + b*x + c = 0):");
        System.out.print("a = ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("b = ");
        double b = Double.parseDouble(input.nextLine());
        System.out.print("c = ");
        double c = Double.parseDouble(input.nextLine());

        if (a == 0) {
            if (b == 0) {
                System.out.println("No solution!");
                return null;
            }
            double sol = -c / b;
            return new double[]{sol};
        }

        double delta = b*b - 4*a*c;

        if (delta < 0) {
            System.out.println("No real solutions!");
            return null;
        }
        else if (delta == 0) {
            double sol = -b / (2*a);
            return new double[]{sol};
        }
        else {
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            return new double[]{x1, x2};
        }
    }
}
