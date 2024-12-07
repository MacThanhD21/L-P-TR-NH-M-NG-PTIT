
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_ChuoiConDaiNhatKhongLap {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);

        String request = "B21DCCN818;KTkglg7X";

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        os.write(request.getBytes());
        os.flush();

        byte[] buf = new byte[1024];
        int len = is.read(buf);
        String inp = (new String(buf, 0, len)).trim();
        System.out.println(inp);

        String ans = "";
        int n = inp.length(), maxLen = 0, start = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int end = 0; end < n; end++) {
            char cur_char = inp.charAt(end);
            if (mp.containsKey(cur_char)) {
                start = Math.max(start, mp.get(cur_char) + 1);
            }
            mp.put(cur_char, end);

            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                ans = inp.substring(start, end + 1);
            }
        }

        int length = ans.length();
        String response = ans + ";" + length;

        os.write(response.getBytes());
        os.flush();

        socket.close();
        is.close();
        os.close();
    }
}
