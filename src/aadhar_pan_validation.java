import java.util.Scanner;
import java.util.regex.*;
public class aadhar_pan_validation {

    private static final String matchAadhar = "^[2-9]{1}[0-9]{11}$";
    private static final String matchPan = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
    public static boolean isValidAadhar(String aadhar) {
        Pattern pattern = Pattern.compile(matchAadhar);
        Matcher matcher = pattern.matcher(aadhar);
        return matcher.matches();
    }
    public static boolean isValidPan(String pan) {
        Pattern pattern = Pattern.compile(matchPan);
        Matcher matcher = pattern.matcher(pan);
        return matcher.matches();
    }

//     Passport Validation
    public static boolean isValidPassportNumber(String passportNumber) {
        String regex = "^[A-Z]{1}[0-9]{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passportNumber);
        return matcher.matches();
    }

//     Driving License Validation
public static boolean isValidDrivingLicenseNumber(String licenseNumber) {
        String regex = "^[A-Za-z]{2}\\d{2}-[0-9]{7}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(licenseNumber);
        return matcher.matches();
}


// Voter ID validation
public static boolean isValidVoterID(String voterID) {
        String regex = "^[A-Z]{3}[0-9]{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(voterID);
        return matcher.matches();
}

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//
//        System.out.println("enter aadhar no");
//        String testAadhar =scanner.next();
//        if (isValidAadhar(testAadhar)) {
//            System.out.println("Valid Aadhar number");
//        } else {
//            System.out.println("Invalid Aadhar number");
//        }
//        // pan validation
////            System.out.println("enter PAN number");
////            String testPan =scanner.next();
////
////            if (isValidPan(testPan)) {
////                System.out.println("Valid PAN number");
////            } else {
////                System.out.println("Invalid PAN number");
////            }
//
//        // passport validation
//        String[] passportNumbers = {"A1234567", "1234567A", "A12345678"};
//
//        for (String passportNumber : passportNumbers) {
//            System.out.println(passportNumber + " is valid? " + isValidPassportNumber(passportNumber));
//                }
//
//            // Driving License Validation
//        System.out.println("Driving License VAlidation");
//        String[] licenseNumbers = {"AB12-1234567-89", "A123-4567890-12", "AB12-123456-78"};
//
//        for (String licenseNumber : licenseNumbers) {
//            System.out.println(licenseNumber + " is valid? " + isValidDrivingLicenseNumber(licenseNumber));
// }
//
//        // voter id validation
//        System.out.println("voter id validation ");
//                String[] voterIDs = {"ABC1234567", "ABCD1234567", "ABC12345678"};
//
//        for (String voterID : voterIDs) {
//            System.out.println(voterID + " is valid? " + isValidVoterID(voterID));
// }
//
//    }

}




