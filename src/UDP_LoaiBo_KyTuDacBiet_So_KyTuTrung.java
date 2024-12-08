import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_LoaiBo_KyTuDacBiet_So_KyTuTrung {
    public static void main(String[] args) throws IOException {
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        // Gửi yêu cầu
        String code = ";B21DCCN010;GfeNSBMT";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        soc.send(dpGui1);

        // Nhận dữ liệu từ server
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        soc.receive(dpNhan);

        // Phân tích dữ liệu
        String inp = new String(dpNhan.getData()).trim();
        System.out.println("Nhận từ server: " + inp);

        String[] data = inp.split(";");
        String reqId = data[0];
        String inpp = data[1];

        // Loại bỏ ký tự số, đặc biệt và trùng lặp, giữ nguyên thứ tự
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();
        for (char c : inpp.toCharArray()) {
            if (Character.isLetter(c)) {
                uniqueChars.add(c);
            }
        }

        // Xây dựng chuỗi kết quả
        StringBuilder resBuilder = new StringBuilder();
        for (char c : uniqueChars) {
            resBuilder.append(c);
        }
        String res = reqId + ";" + resBuilder.toString();

        System.out.println("Kết quả gửi: " + res);

        // Gửi kết quả lại server
        DatagramPacket dpGui2 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        soc.send(dpGui2);

        // Đóng socket
        soc.close();
    }
}
