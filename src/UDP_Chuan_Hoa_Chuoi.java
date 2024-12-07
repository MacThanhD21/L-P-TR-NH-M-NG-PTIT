
import java.io.*;
import java.net.*;
import java.util.*;


public class UDP_Chuan_Hoa_Chuoi {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        
        // send data 
        String code = ";B21DCCN677;1SX5uItz";
        DatagramPacket dpSend1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpSend1);
        
        // receive
        byte[] buf = new byte[1024];
        DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
        socket.receive(dpReceive);
        
        String dataReceive = new String(dpReceive.getData()).trim();
        System.out.println(dataReceive);
        
        // handle
        String[] parts = dataReceive.split(";");
        String requestId = parts[0];
        String data = parts[1];
        
        String[] words = data.split(" ");
        // normalize
        String nor_Data = "";
        for(String x : words) {
            nor_Data += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
            nor_Data += " ";
        }
        nor_Data = nor_Data.trim();
        System.out.println(nor_Data);
        String result = requestId + ";" + nor_Data;
        DatagramPacket dpSend2 = new DatagramPacket(result.getBytes(), result.length(), sA, sP);
        socket.send(dpSend2);
        
        socket.close();
    }
}
