
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
        
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        int maxLength = findLongestIncreasingSubsequence(array);

        // Gửi độ dài về server
        os.write(String.valueOf(maxLength).getBytes());
        os.flush();
        
        socket.close();
        is.close();
        os.close();
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
