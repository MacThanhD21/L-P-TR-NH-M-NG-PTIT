

import java.io.*;
import java.net.*;
import java.util.*;


public class UDP_Mat_Ma_Caesar {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2007;
        
        // Send Data
        String code = ";B21DCCN008;fD3ur1sI";
        DatagramPacket dpCode = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpCode);
        
        // Receive Data
        byte[] buf = new byte[1024];
        DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
        socket.receive(dpReceive);
        
        String tmp = (new String(dpReceive.getData())).trim();
        System.out.println(tmp);
        
        // Có String: requestId;strEncode;s
        String[] res = tmp.split(";");
        String reqId = res[0];
        String data = res[1];
        int s = Integer.parseInt(res[2]);
        
        // Process
        String ans = "";
        for(char c : data.toCharArray()) {
            if(Character.isUpperCase(c)) {
                ans += ('A' + (c - 'A' + 26) % 26);
            } else if (Character.isLowerCase(c)) {
                ans += ('a' + (c - 'a' + 26) % 26);
            } else {
                ans += c;
            }
        }
        String result = reqId + ";" + ans;
        DatagramPacket dpResult = new DatagramPacket(result.getBytes(), result.length(), sA, sP);
        socket.send(dpResult);
        socket.close();
    }
}

/*
[Mã câu hỏi (qCode): fD3ur1sI].  Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự “A” sẽ được thay thế bằng ký tự “D”.
Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu xây dựng chương trình client trao đổi thông tin với server theo kịch bản mô tả dưới đây:
a.	Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;825EE3A7"
b.	Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;strEncode;s".
•	requestId là chuỗi ngẫu nhiên duy nhất
•	strEncode là chuỗi thông điệp bị mã hóa
•	s là số nguyên chứa giá trị độ dịch của mã
c.	Giải mã tìm thông điệp ban đầu và gửi lên server theo định dạng “requestId;strDecode”
d.	Đóng socket và kết thúc chương trình.
*/
