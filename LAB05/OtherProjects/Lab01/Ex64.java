import java.util.Scanner;

public class Ex64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter month and year:");
            
            String monthInput = getMonthInput(scanner);
            if (monthInput == null) continue;
            
            int year = getYearInput(scanner);
            if (year == -1) continue;
            
            int monthNumber = convertMonthToNumber(monthInput);
            if (monthNumber == -1) {
                System.out.println("Invalid month! Try again.");
                continue;
            }
            
            int days = getDaysInMonth(monthNumber, year);
            String monthName = getMonthName(monthNumber);
            
            System.out.println(monthName + " " + year + " has " + days + " days.");
            
            System.out.print("Do you want to continue? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y") && !choice.equals("yes")) {
                break;
            }
        }
        
        scanner.close();
        System.out.println("Thank you!");
    }
    
    private static String getMonthInput(Scanner scanner) {
        System.out.print("Enter month (full name, abbreviation, 3 letters, or number): ");
        String input = scanner.nextLine().trim();
        
        if (input.isEmpty()) {
            System.out.println("Invalid input! Try again.");
            return null;
        }
        
        return input;
    }
    
    private static int getYearInput(Scanner scanner) {
        System.out.print("Enter year (4 digits): ");
        String yearInput = scanner.nextLine().trim();
        
        try {
            int year = Integer.parseInt(yearInput);
            if (year < 0) {
                System.out.println("Year must be non-negative! Please try again.");
                return -1;
            }
            if (yearInput.length() != 4) {
                System.out.println("Year must have exactly 4 digits! Please try again.");
                return -1;
            }
            return year;
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format! Please enter a 4-digit number.");
            return -1;
        }
    }
    
    private static int convertMonthToNumber(String monthInput) {
        String input = monthInput.toLowerCase();
        
        String[] fullNames = {"january", "february", "march", "april", "may", "june",
                             "july", "august", "september", "october", "november", "december"};
        
        String[] abbreviations = {"jan.", "feb.", "mar.", "apr.", "may", "june",
                                "july", "aug.", "sept.", "oct.", "nov.", "dec."};
        
        String[] threeLetters = {"jan", "feb", "mar", "apr", "may", "jun",
                               "jul", "aug", "sep", "oct", "nov", "dec"};
        
        for (int i = 0; i < fullNames.length; i++) {
            if (input.equals(fullNames[i])) {
                return i + 1;
            }
        }
        
        for (int i = 0; i < abbreviations.length; i++) {
            if (input.equals(abbreviations[i])) {
                return i + 1;
            }
        }
        
        for (int i = 0; i < threeLetters.length; i++) {
            if (input.equals(threeLetters[i])) {
                return i + 1;
            }
        }
        
        try {
            int monthNum = Integer.parseInt(input);
            if (monthNum >= 1 && monthNum <= 12) {
                return monthNum;
            }
        } catch (NumberFormatException e) {

        }
        
        return -1;
    }
    
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
    
    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                             "July", "August", "September", "October", "November", "December"};
        
        if (month >= 1 && month <= 12) {
            return monthNames[month - 1];
        }
        return "Invalid Month";
    }
}
