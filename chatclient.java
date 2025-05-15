import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);
            System.out.println("Connected to server!");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Server disconnected.");
                }
            }).start();
            String userInput;
            while ((userInput = keyboard.readLine()) != null) {
                out.println(userInput);
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
