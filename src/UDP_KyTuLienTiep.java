
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

        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        String result = reqId + ";";
        for (char c : mp.keySet()) {
            result += mp.get(c) + "" + (char) c;
        }
        DatagramPacket dpGui2 = new DatagramPacket(result.getBytes(), result.length(), sA, sP);
        socket.send(dpGui2);

    }
}
