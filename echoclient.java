import java.io.*;
import java.net.*;
public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);
            System.out.println("Connected to Echo Server.");
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String input;
            while (true) {
                System.out.print("Enter message (type 'exit' to quit): ");
                input = keyboard.readLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                out.println(input); // send to server
                String response = in.readLine(); // receive from server
                System.out.println("From server: " + response);
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
