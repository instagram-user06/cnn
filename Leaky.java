import java.util.*;

class Queue {
    int[] q = new int[10];
    int f = 0, r = 0;
    void insert(int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + " element: ");
            int ele = in.nextInt();

            if (r >= 10) {
                System.out.println("Queue is full");
                System.out.println("Lost Packet: " + ele);
                break;
            } else {
                q[r++] = ele;
            }
        }
    }
    void delete() {
        if (r == 0) {
            System.out.println("Queue empty");
        } else {
            System.out.println("\nLeaking packets...");
            for (int i = f; i < r; i++) {
                try {
                    Thread.sleep(1000); // Simulate leak rate
                } catch (Exception e) {
                    System.out.println("Error in sleep: " + e);
                }
                System.out.println("Leaked Packet: " + q[i]);
            }
            f = r; // Reset queue after leak
        }
        System.out.println();
    }
}
public class Leaky {
    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner src = new Scanner(System.in);
        System.out.print("Enter the number of packets to be sent: ");
        int size = src.nextInt();
        q.insert(size);
        q.delete();
    }
}
