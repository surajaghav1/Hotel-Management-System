import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class number_validation {

    // number validation
    public static boolean containsOnlyNumbers(String input) {
        // Regular expression to match only numbers
        String regex = "^[0-9]+$";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Check if the input matches the pattern
        return pattern.matcher(input).matches();
    }

    // mobile number validation
        public static boolean isValidMobileNumber(String number) {
            // Regular expression for a typical 10-digit mobile number
            String regex = "^[0-9]{10}$";

            // Compile the regular expression
            Pattern pattern = Pattern.compile(regex);

            // Create matcher object
            Matcher matcher = pattern.matcher(number);

            // Check if the provided number matches the pattern
            return matcher.matches();
        }

    public static void main(String[] args) {
        // Test the validator
        String[] inputs = {"12345", "56789", "123abc", "abc123", "4567.89"};

        for (String input : inputs) {
            System.out.println(input + " contains only numbers? " + containsOnlyNumbers(input));
        }
        String[] numbers = {"1234567890", "987654321", "12345678901"};

        for (String number : numbers) {
            System.out.println(number + " is valid? " + isValidMobileNumber(number));
        }


    }
}