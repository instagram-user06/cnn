import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");
        InputStream is = socket.getInputStream();
        String folderPath = "C:\\Users\\HP\\Desktop\\CN";
        File dir = new File(folderPath);
        if (!dir.exists()) {
            dir.mkdirs(); 
        }
        FileOutputStream fos = new FileOutputStream(folderPath + "\\gokul.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] contents = new byte[10000];
        int bytesRead;
        while ((bytesRead = is.read(contents)) != -1) {
            bos.write(contents, 0, bytesRead);
        }
        bos.flush();
        bos.close();
        socket.close();
        System.out.println("File received successfully!");
        System.out.println("Saved to: " + folderPath + "\\gokul");
    }
}
