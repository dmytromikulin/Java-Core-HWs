import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class JsonPlaceholderClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException {
        System.out.println("== Get All Users ==");
        getAllUsers();

        System.out.println("\n== Get User by ID ==");
        getUserById(1);

        System.out.println("\n== Get User by Username ==");
        getUserByUsername("Bret");

        System.out.println("\n== Create New User ==");
        createUser();

        System.out.println("\n== Update User ==");
        updateUser(1);

        System.out.println("\n== Delete User ==");
        deleteUser(1);

        System.out.println("\n== Get Comments of Last Post for User ==");
        getCommentsOfLastPostForUser(1);

        System.out.println("\n== Get Open Tasks for User ==");
        getOpenTasksForUser(1);
    }

    private static void getAllUsers() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET All Users Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("GET request failed");
        }
    }

    private static void getUserById(int id) throws IOException {
        URL url = new URL(BASE_URL + "/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET User by ID Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("GET request failed");
        }
    }

    private static void getUserByUsername(String username) throws IOException {
        URL url = new URL(BASE_URL + "?username=" + username);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET User by Username Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("GET request failed");
        }
    }

    private static void createUser() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        String jsonInputString = "{\"name\":\"John Doe\",\"username\":\"johndoe\",\"email\":\"johndoe@example.com\"}";
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST Create User Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("POST request failed");
        }
    }

    private static void updateUser(int userId) throws IOException {
        URL url = new URL(BASE_URL + "/" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        String jsonInputString = "{\"id\":" + userId + ",\"name\":\"Updated Name\",\"username\":\"updatedusername\",\"email\":\"updated@example.com\"}";
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("PUT Update User Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("PUT request failed");
        }
    }

    private static void deleteUser(int userId) throws IOException {
        URL url = new URL(BASE_URL + "/" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");

        int responseCode = connection.getResponseCode();
        System.out.println("DELETE User Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("DELETE request failed");
        }
    }

    private static void getCommentsOfLastPostForUser(int userId) throws IOException {
        URL url = new URL(BASE_URL + "/" + userId + "/posts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Posts for User Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String postsResponse = response.toString();
            int lastPostId = getLastPostId(postsResponse);

            if (lastPostId != -1) {
                getCommentsForPost(userId, lastPostId);
            } else {
                System.out.println("No posts found for user.");
            }

        } else {
            System.out.println("GET request for posts failed");
        }
    }

    private static int getLastPostId(String postsResponse) {
        String[] posts = postsResponse.split("\\{");
        int maxId = -1;

        for (String post : posts) {
            if (post.contains("\"id\":")) {
                int idStart = post.indexOf("\"id\":") + 5;
                int idEnd = post.indexOf(",", idStart);
                int postId = Integer.parseInt(post.substring(idStart, idEnd).trim());
                if (postId > maxId) {
                    maxId = postId;
                }
            }
        }
        return maxId;
    }

    private static void getCommentsForPost(int userId, int postId) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Comments for Post Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(response.toString());
                System.out.println("Comments saved to file: " + fileName);
            }
        } else {
            System.out.println("GET request for comments failed");
        }
    }

    private static void getOpenTasksForUser(int userId) throws IOException {
        URL url = new URL(BASE_URL + "/" + userId + "/todos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Open Tasks for User Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String tasksResponse = response.toString();
            printOpenTasks(tasksResponse);

        } else {
            System.out.println("GET request for open tasks failed");
        }
    }

    private static void printOpenTasks(String tasksResponse) {
        String[] tasks = tasksResponse.split("\\{");

        System.out.println("Open Tasks for User:");
        for (String task : tasks) {
            if (task.contains("\"completed\":false")) {
                System.out.println("{" + task.trim());
            }
        }
    }
}
