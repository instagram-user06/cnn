import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ssock = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client connection...");
        Socket socket = ssock.accept();
        System.out.println("Client connected.");
        File file = new File("C:\\Users\\HP\\Desktop\\gokul.txt");
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            socket.close();
            ssock.close();
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream os = socket.getOutputStream();
        byte[] contents;
        long fileLength = file.length();
        long current = 0;
        System.out.println("Sending file: " + file.getName());
        while (current != fileLength) {
            int size = 10000;
            if (fileLength - current >= size) {
                contents = new byte[size];
                bis.read(contents, 0, size);
                os.write(contents);
                current += size;
            } else {
                size = (int)(fileLength - current);
                contents = new byte[size];
                bis.read(contents, 0, size);
                os.write(contents);
                current = fileLength;
            }
            System.out.println("Progress: " + (current * 100 / fileLength) + "%");
        }
        os.flush();
        bis.close();
        socket.close();
        ssock.close();
        System.out.println("File sent successfully!");
    }
}
