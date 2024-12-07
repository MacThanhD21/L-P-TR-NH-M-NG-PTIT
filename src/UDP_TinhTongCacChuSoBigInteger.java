
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_TinhTongCacChuSoBigInteger {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        
        String code = ";B21DCCN677;1EyBeTvm";
        DatagramPacket dpSend1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpSend1);
        
        // receive
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        socket.receive(dpNhan);
        
        String dataRev = new String(dpNhan.getData()).trim();
        System.out.println(dataRev);
        String[] parts = dataRev.split(";");
        
        String requestId = parts[0];
        String data = parts[1];
        int sumDigits = 0;
        for(char c : data.toCharArray()) {
            sumDigits += Character.getNumericValue(c);
        }
        String ans = requestId + ";" + sumDigits;
        DatagramPacket dpSend2 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpSend2);
        socket.close();
    }
}
