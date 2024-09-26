class Main {
    public static void main(String[] args) {
        String filePath = "file.txt";

        PhoneNumberFileReader fileReader = new PhoneNumberFileReader(filePath);

        fileReader.readAndPrintValidPhoneNumbers();
    }
}
