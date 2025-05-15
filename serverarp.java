import java.io.*;
import java.net.*;

class Serverarp {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(5604);
            System.out.println("Server is running... Waiting for client...");
            Socket client = server.accept(); 
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            String str = in.readLine();
            String ip[] = {"165.165.80.80", "165.165.79.1"};
            String mac[] = {"6A:08:AA:C2", "8A:BC:E3:FA"};
            boolean found = false;
            for (int i = 0; i < ip.length; i++) {
                if (str.equals(ip[i])) {
                    out.println(mac[i]); 
                    found = true;
                    break;
                }
            }
            if (!found) {
                out.println("MAC Address not found");
            }
            client.close();
            server.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
