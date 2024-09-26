package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class UserFileReader {
    public List<User> readUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);

                users.add(new User(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
