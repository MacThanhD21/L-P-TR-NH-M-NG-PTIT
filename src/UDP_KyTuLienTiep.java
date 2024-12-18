
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_KyTuLienTiep {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        String code = ";B21DCCN004;19wupYAB";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui1);

        // Step 2: Receive response from server
        byte[] buf = new byte[1024];
        DatagramPacket dpRev = new DatagramPacket(buf, buf.length);
        socket.receive(dpRev);
        
        String received = (new String(dpRev.getData())).trim();
        System.out.println(received);
        
        String[] data = received.split(";");
        String reqId = data[0];
        String str = data[1];
        
        System.out.println("Received data: " + str);

        Map<Character, Integer> mp = new HashMap<>();
        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        String ans = "";
        Set<Character> se = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (!se.contains(c)) {
                ans += mp.get(c) + (c + "");
                se.add(c);
            }
        }
        
        String result = reqId + ";" + ans;
        System.out.println("Processed data: " + result);

        // Step 5: Send processed data back to server
        DatagramPacket dpGui2 = new DatagramPacket(result.getBytes(), result.length(), sA, sP);
        socket.send(dpGui2);

        // Step 6: Close socket
        socket.close();
    }
}
