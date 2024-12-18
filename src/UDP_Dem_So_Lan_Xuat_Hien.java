
import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_Dem_So_Lan_Xuat_Hien {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        String code = ";B21DCCN002;vSgxl3HQ";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui1);

        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        socket.receive(dpNhan);

        String[] inp = new String(dpNhan.getData()).split(";");
        String reqId = inp[0];
        String data = inp[1];

        int coun = 1;
        String ans = "";
        
        for(int i = 1; i < data.length(); i++) {
            if(data.charAt(i) == data.charAt(i - 1)) {
                coun++;
            }
            else {
                ans += coun + (data.charAt(i - 1) + "");
                coun = 1;
            }
        }
        
        
        ans = reqId + ";" + ans;
        System.out.println(ans);

        DatagramPacket dpGui2 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui2);

        socket.close();

    }
}

/*

[Mã câu hỏi (qCode): HS0sHUjn].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi một thông điệp chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;9F8C2D3A".
b. Nhận một thông điệp từ server theo định dạng "requestId;data", với:
    requestId là chuỗi ngẫu nhiên duy nhất.
    data là một chuỗi ký tự liên tiếp cần xử lý. Ví dụ: "requestId;aaabbbccdaa"

c. Xử lý chuỗi bằng cách đếm số lượng ký tự liên tiếp và gom chúng lại theo định dạng "số_lần_ký_tự". Gửi kết quả về server theo định dạng:
    "requestId;processedData"
Ví dụ: Với chuỗi "aaabbbccdaa", kết quả sẽ là: "requestId;3a3b2c1d2a"

d. Đóng socket và kết thúc chương trình.
*/
