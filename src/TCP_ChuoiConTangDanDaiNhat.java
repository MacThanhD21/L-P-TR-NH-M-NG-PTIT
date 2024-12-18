
import java.io.*;
import java.net.*;

public class TCP_ChuoiConTangDanDaiNhat {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        String code = "B21DCCN007;f3aTD8yw";

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        // Gửi mã sinh viên và mã câu hỏi
        os.write(code.getBytes());
        os.flush();


        // Nhận dữ liệu từ server
        byte[] data = new byte[1024];
        int len = is.read(data);

        // Xử lý dữ liệu nhận được
        String dataStr = (new String(data, 0, len)).trim();
        System.out.println("Dữ liệu nhận được: " + dataStr);
        String[] numbers = dataStr.split(",");
        
        int[] ar = new int[numbers.length];
        int[] dp = new int[ar.length];
        for(int i = 0; i < ar.length; i++) {
            dp[i] = 1;
        }
        for(int i = 0; i < numbers.length; i++) {
            ar[i] = Integer.parseInt(numbers[i]);
        }

        int maxLen = 0;
        for(int i = 0; i < ar.length; i++) {
            for(int j = 0; j < i; j++) {
                if(ar[i] > ar[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        // Gửi độ dài về server
        os.write((maxLen + "").getBytes());
        os.flush();
        
        socket.close();
        is.close();
        os.close();
    }
}
