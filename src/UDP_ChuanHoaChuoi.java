
import java.io.*;
import java.net.*;

public class UDP_ChuanHoaChuoi {
    public static void main(String[] args) throws IOException{
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        
        String code = ";B21DCCN007;Zdkwi0IZ";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        soc.send(dpGui1);
        
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        soc.receive(dpNhan);
        
        String inp = (new String(dpNhan.getData())).trim();
        System.out.println(inp);
        
        String[] data = inp.split(";");
        String reqId = data[0];
        String[] s = data[1].split("\\s+");
        
        String chuanHoa = "";
        for(String x : s) {
            
            chuanHoa += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase()+ " ";
        }
        chuanHoa = chuanHoa.trim();
        System.out.println(chuanHoa);
        
        String result = reqId + ";" + chuanHoa;
        DatagramPacket dpGui2 = new DatagramPacket((result).getBytes(), result.length(), sA, sP);
        
        soc.send(dpGui2);
    }
}
