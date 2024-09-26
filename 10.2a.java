package org.example;

import java.util.List;
class Main {
    public static void main(String[] args) {
        String inputFilePath = "file.txt";
        String outputFilePath = "user.json";

        UserFileReader reader = new UserFileReader();
        List<User> users = reader.readUsersFromFile(inputFilePath);

        UserFileWriter writer = new UserFileWriter();
        writer.writeUsersToJson(users, outputFilePath); 
    }
}
