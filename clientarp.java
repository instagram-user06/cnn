import java.io.*; 
import java.net.*; 
class Clientarp {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Socket clsct = new Socket("127.0.0.1", 5604);
            DataOutputStream dout = new DataOutputStream(clsct.getOutputStream());
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(clsct.getInputStream()));
            System.out.println("Enter the Logical address (IP):");
            String str1 = in.readLine();
            dout.writeBytes(str1 + '\n'); 
            String str = serverInput.readLine(); 
            System.out.println("The Physical Address is: " + str);
            clsct.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
