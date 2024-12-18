import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_LoaiBo_KyTuDacBiet_So_KyTuTrung {
    public static void main(String[] args) throws IOException {
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        String code = ";B21DCCN010;GfeNSBMT";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        soc.send(dpGui1);

        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        soc.receive(dpNhan);

        String inp = new String(dpNhan.getData()).trim();
        System.out.println("Nhận từ server: " + inp);

        String[] data = inp.split(";");
        String reqId = data[0];
        String inpp = data[1];

        // Loại bỏ ký tự số, đặc biệt và trùng lặp, giữ nguyên thứ tự
        LinkedHashSet<Character> se = new LinkedHashSet<>();
        for (char c : inpp.toCharArray()) {
            if (Character.isLetter(c)) {
                se.add(c);
            }
        }

        // Xây dựng chuỗi kết quả
        String ans = "";
        for (char c : se) {
            ans += (c + "");
        }
        String res = reqId + ";" + ans;

        System.out.println("Kết quả gửi: " + res);

        DatagramPacket dpGui2 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        soc.send(dpGui2);

        soc.close();
    }
}
