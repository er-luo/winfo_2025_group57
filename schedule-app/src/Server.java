import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.InetSocketAddress;
import org.json.JSONObject;  // Use the org.json library for parsing JSON

public class Server {

    public static void main(String[] args) throws Exception {
        // Create HTTP server on localhost and port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/tasks", new TaskHandler());  // /tasks endpoint to manage tasks
        server.setExecutor(null);  // Default executor
        server.start();
        System.out.println("Server started at http://localhost:8080");
    }

    static class TaskHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";
            if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
                BufferedReader reader = new BufferedReader(isr);
                String inputLine;
                StringBuilder requestBody = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    requestBody.append(inputLine);
                }

                // Parse the input JSON and add a task
                JSONObject requestBodyJson = new JSONObject(requestBody.toString());
                handlePostRequest(requestBodyJson);  // Call the method to add task

                response = "Task added successfully!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
            } else {
                // Handle any other HTTP 
                response = "Invalid request method!";
                exchange.sendResponseHeaders(405, response.getBytes().length); // Not Allowed
            }

            // Send the response
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        // Method to handle POST request and add task
        public static void handlePostRequest(JSONObject requestBody) {
            // Parse the necessary fields from the requestBody
            String name = requestBody.getString("name");
            String dueDate = requestBody.getString("dueDate");
            String category = requestBody.getString("category");
            int difficulty = requestBody.getInt("difficulty");

            // Add the task (use the taskAdd method from main)
            taskAdd(dueDate, name, category, difficulty);
        }
    }
}