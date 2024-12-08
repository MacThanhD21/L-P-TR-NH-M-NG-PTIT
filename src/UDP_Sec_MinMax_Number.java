
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_Sec_MinMax_Number {

    public static void main(String[] args) throws IOException {
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;

        String code = ";B21DCCN007;c6s9Ppx3";

        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        soc.send(dpGui1);

        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length, sA, sP);
        soc.receive(dpNhan);

        String inp = (new String(dpNhan.getData())).trim();
        System.out.println(inp);

        String[] data = inp.split(";");
        String rId = data[0];
        String[] s = data[1].split(",");

        List<Integer> nums = new ArrayList<>();
        for (String x : s) {
            nums.add(Integer.parseInt(x));
        }
        Collections.sort(nums);
        System.out.println(nums);

        String ans = rId + ";" + nums.get(nums.size() - 2) + "," + nums.get(1);
        System.out.println(ans);

        DatagramPacket dpGui2 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        soc.send(dpGui2);
    }
}
