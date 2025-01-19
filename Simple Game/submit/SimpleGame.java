import java.util.Scanner;

public class SimpleGame {

    /**
     * Write a method to convert the given seconds to hours:minutes:seconds.
     * @param seconds to convert
     * @return string for the converted seconds in the format: 23:59:59
     */
    public String convertTime(int seconds) {
        if (seconds < 0) {
            return "-1:-1:-1"; // Handle invalid input (negative seconds)
        }

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        return hours + ":" + minutes + ":" + remainingSeconds;
    }

    /**
     * Write a method that adds all the digits in the given non-negative integer.
     * @param input to add digits
     * @return integer in which all the digits in the given non-negative integer are added.
     */
    public int digitsSum(int input) {
        if (input == 0) {
            return 0;
        }

        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Create an instance of the SimpleGame class.
        SimpleGame game = new SimpleGame();

        Scanner sc = new Scanner(System.in);

        // Ask the user which game to play.
        System.out.println("Welcome to the SimpleGame!");
        System.out.println("Choose an option:");
        System.out.println("1. Convert time from seconds to hours:minutes:seconds");
        System.out.println("2. Calculate the sum of digits in an integer");

        int choice = sc.nextInt();

        // If the user enters 1, ask for an integer to convert and call the convertTime method.
        if (choice == 1) {
            System.out.println("Enter the number of seconds:");
            int seconds = sc.nextInt();
            String time = game.convertTime(seconds);
            System.out.println("Converted time: " + time);
        }
        // If the user enters 2, ask for an integer and call the digitsSum method.
        else if (choice == 2) {
            System.out.println("Enter a number to calculate the sum of digits:");
            int number = sc.nextInt();
            int sum = game.digitsSum(number);
            System.out.println("Sum of digits: " + sum);
        } else {
            System.out.println("Invalid option. Please choose 1 or 2.");
        }

        sc.close();
    }
}
