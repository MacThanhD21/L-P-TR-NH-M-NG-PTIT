
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_KyTuXuatHienNhieuNhat_VaCacViTriXuatHien {

    public static void main(String[] args) throws IOException {
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        // Gửi yêu cầu
        String code = ";B21DCCN011;CvlqJmaa";
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
        String strData = data[1];

        Map<Character, List<Integer>> mp = new HashMap<>();
        int maxCount = 0;
        char v = '@';
        // Lưu vị trí và đếm số lần xuất hiện

        for (int i = 0; i < strData.length(); i++) {
            char c = strData.charAt(i);
            mp.putIfAbsent(c, new ArrayList<>());
            mp.get(c).add(i + 1);

            int coun = mp.get(c).size();
            if (coun > maxCount) {
                maxCount = coun;
                v = c;
            }
        }

        // Lấy các vị trí của ký tự xuất hiện nhiều nhất
        
        String poss = "";
        for(int pos : mp.get(v)) {
            poss += pos + ",";
        }
        
        // Chuẩn bị kết quả
        String result = reqId + ";" + v + ":" + poss;
        System.out.println("Kết quả gửi: " + result);

        // Gửi kết quả lên server
        DatagramPacket dpGui2 = new DatagramPacket(result.getBytes(), result.length(), sA, sP);
        soc.send(dpGui2);

        // Đóng socket
        soc.close();
    }
}
