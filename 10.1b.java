import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PhoneNumberFileReader {
    private String filePath;
    private PhoneNumberValidator validator;

    public PhoneNumberFileReader(String filePath) {
        this.filePath = filePath;
        this.validator = new PhoneNumberValidator();
    }

    public void readAndPrintValidPhoneNumbers() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (validator.isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
