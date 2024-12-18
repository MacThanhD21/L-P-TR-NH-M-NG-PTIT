
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_KyTuXuatHienNhieuNhat_VaCacViTriXuatHien {

    public static void main(String[] args) throws IOException {
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        
        String code = ";B21DCCN050;p9UmgZRd";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        soc.send(dpGui1);
        
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length, sA, sP);
        soc.receive(dpNhan);
        
        String inp = (new String(dpNhan.getData())).trim();
        System.out.println(inp);
        
        String[] res = inp.split(";");
        String reqId = res[0];
        
        String data = res[1];
        
        Map<Character, List<Integer>> mp = new HashMap<>();
        
        char charMax = ' ';
        int maxCoun = 0;
        
        for(int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            mp.computeIfAbsent(c, k -> new ArrayList<>()).add(i + 1);
            if(mp.get(c).size() > maxCoun) {
                charMax = c;
                maxCoun = mp.get(c).size();
            }
        }
        String poss = "";
        for(int pos : mp.get(charMax)) {
            poss += (pos + "") + ",";
        }
        String ans = reqId + ";" + charMax + ":" + poss;
        
        DatagramPacket dpGui2 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        soc.send(dpGui2);
        
    }
}
