import java.io.*;
import java.net.*;

 public class SimpleHTTPClient {
     public static void main(String[] args) {
         try {
             URI uri = URI.create("http://neverssl.com"); // Try unblocked site
             URL url = uri.toURL();

             HttpURLConnection con = (HttpURLConnection) url.openConnection();
             con.setRequestMethod("GET");
            con.setInstanceFollowRedirects(true);

             BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
             String inputLine;

             while ((inputLine = in.readLine()) != null) {
                 System.out.println(inputLine);
             }

             in.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }



