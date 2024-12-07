
import java.io.*;
import java.net.*;

public class TCP_ChuoiConTangDanDaiNhat {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        String code = "B21DCCN001;XGIm2Fc7";

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        try {
            // Gửi mã sinh viên và mã câu hỏi
            os.write(code.getBytes());
            os.flush();
            
            System.out.println("ok");

            // Nhận dữ liệu từ server
            byte[] data = new byte[1024];
            int len = is.read(data);
            System.out.println(len);
            if (len == -1) {
                System.out.println("Không nhận được dữ liệu từ server.");
                return;
            }

            // Xử lý dữ liệu nhận được
            String dataStr = (new String(data, 0, len)).trim();
            System.out.println("Dữ liệu nhận được: " + dataStr);
            String[] numbers = dataStr.split(",");
            int[] array = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i]);
            }

            // Tìm chuỗi con tăng dần dài nhất
            int maxLength = findLongestIncreasingSubsequence(array);
            System.out.println("Độ dài chuỗi con tăng dần dài nhất: " + maxLength);

            // Gửi độ dài về server
            os.write(String.valueOf(maxLength).getBytes());
            os.flush();
        } finally {
            // Đóng kết nối
            socket.close();
            is.close();
            os.close();
        }
    }

    // Hàm tìm chuỗi con tăng dần dài nhất
    public static int findLongestIncreasingSubsequence(int[] array) {
        int n = array.length;
        int[] dp = new int[n];

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
