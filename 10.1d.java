import java.util.regex.Pattern;
import java.util.regex.Matcher;

class PhoneNumberValidator {
    public boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PhoneNumberPattern.PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
