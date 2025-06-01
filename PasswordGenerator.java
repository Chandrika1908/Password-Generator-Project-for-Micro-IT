import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        String allowedChars = "";

        // Build character set based on user selection
        if (useUpper) allowedChars += upperCase;
        if (useLower) allowedChars += lowerCase;
        if (useDigits) allowedChars += digits;
        if (useSpecial) allowedChars += specialChars;

        // Validate input
        if (allowedChars.isEmpty()) {
            return "Error: No character types selected!";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUpper = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean useLower = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean useDigits = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean useSpecial = scanner.nextBoolean();

        String password = generatePassword(length, useUpper, useLower, useDigits, useSpecial);

        System.out.println("\nGenerated Password: " + password);
    }
}
