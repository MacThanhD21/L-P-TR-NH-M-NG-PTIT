
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_DanhSachNSoNguyenTo {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;

        String code = ";B21DCCN003;7TP8Nw2c";
        DatagramPacket dpSend1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpSend1);

        byte[] buf = new byte[1024];
        DatagramPacket dpRev = new DatagramPacket(buf, buf.length);
        socket.receive(dpRev);

        String[] data = (new String(dpRev.getData())).trim().split(";");

        String reqId = data[0];
        int N = Integer.parseInt(data[1]);
        System.out.println(N);
        String res = "";
        int cnt = 0;
        for (int i = 2; i <= 1000000; i++) {
            if (isPrime(i)) {
                cnt++;

                res += i;
                if (cnt != N) {
                    res += ",";
                }
                if (cnt == N) {
                    break;
                }
            }

        }
        System.out.println(res);
        String ans = reqId + ";" + res;
        System.out.println(ans);

        DatagramPacket dpSend2 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpSend2);
    }

    public static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}
