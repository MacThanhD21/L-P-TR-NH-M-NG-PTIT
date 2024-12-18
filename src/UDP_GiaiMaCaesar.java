
import java.net.*;
import java.io.*;
import java.util.*;

public class UDP_GiaiMaCaesar {
    public static void main(String[] args) throws Exception{
        DatagramSocket soc = new DatagramSocket();
        InetAddress sa = InetAddress.getByName("203.162.10.109");
        int sp = 2207;
        
        String code = ";B21DCCN014;J5SE2YXc";
        
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sa, sp);
        soc.send(dpGui1);
        
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length, sa, sp);
        soc.receive(dpNhan);
        
        String inp = (new String(dpNhan.getData(), 0, dpNhan.getLength())).trim();
        System.out.println(inp);
        
        String[] data = inp.split(";");
        String reqId = data[0];
        String str = data[1];
        int shift = Integer.parseInt(data[2]);
        
        String ans = "";
        for(char c : str.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            ans += (char) ((c - base + shift) % 26 + base);
        }
        
        System.out.println(ans);
        
        String res = reqId + ";" + ans;
        DatagramPacket dpGui2 = new DatagramPacket (res.getBytes(), res.length(), sa, sp);
        soc.send(dpGui2);
    }
}
