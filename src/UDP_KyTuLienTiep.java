
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_KyTuLienTiep {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        // Step 1: Send initial request
        String code = ";B21DCCN818;zB9GX8Ub";
        DatagramPacket dpSend1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpSend1);

        // Step 2: Receive response from server
        byte[] buf = new byte[1024];
        DatagramPacket dpRev = new DatagramPacket(buf, buf.length);
        socket.receive(dpRev);
        String received = new String(dpRev.getData(), 0, dpRev.getLength());
        
        String[] data = received.split(";");
        String reqId = data[0];
        String str = data[1];
        System.out.println("Received data: " + str);

        // Step 3: Count the occurrences of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 4: Build the processed data in the desired format
        String processData = "";
        Set<Character> processedChars = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (!processedChars.contains(c)) {
                processData += charCount.get(c) + (c + "");
                processedChars.add(c);
            }
        }
        
        String result = reqId + ";" + processData;
        System.out.println("Processed data: " + result);

        // Step 5: Send processed data back to server
        DatagramPacket dpSend2 = new DatagramPacket(result.getBytes(), result.length(), sA, sP);
        socket.send(dpSend2);

        // Step 6: Close socket
        socket.close();
    }
}
