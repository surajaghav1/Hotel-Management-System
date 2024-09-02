import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class name_validation {
    private static final String matchEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String matchName = "^[a-zA-Z]+(\\s[a-zA-Z]+)?$";
    private static final String matchCompany = "^[a-zA-Z\\s]+$";
    private static final String matchPincode = "^[1-9][0-9]{5}$";


    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(matchName);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean isValidCompany(String name) {
        Pattern pattern = Pattern.compile(matchCompany);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(matchEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPincode(String pincode) {
        Pattern pattern = Pattern.compile(matchPincode);
        Matcher matcher = pattern.matcher(pincode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
//        System.out.println("enter your name ");
//        String testName =s.nextLine();
//        if (isValidName(testName)) {
//            System.out.println("Name is valid");
//        } else {
//            System.out.println("Invalid name");
//        }

        // email validation
//        System.out.println("enter your email id");
//        String testEmail = s.nextLine();
//
//        if (isValidEmail(testEmail)) {
//            System.out.println("Valid email");
//        } else {
//            System.out.println("Invalid email");
//        }
        // pincode validation
        System.out.println("enter pincode ");
        String testPincode =s.next();

        if (isValidPincode(testPincode)) {
            System.out.println("Valid PIN code");
        } else {
            System.out.println("Invalid PIN code");
        }


    }




}

