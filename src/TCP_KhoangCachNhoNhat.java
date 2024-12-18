
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_KhoangCachNhoNhat {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        String code = "B21DCCN677;SYqFOR5r";

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        os.write(code.getBytes());
        os.flush();

        // receive data: Type String
        byte[] data = new byte[1024];
        int len = is.read(data);
        String dataStr = (new String(data, 0, len)).trim();
        System.out.println(dataStr);

        String[] dataArr = dataStr.split(",");

        int minDistance = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        List<Integer> arr = new ArrayList<>();
        for (String x : dataArr) {
            arr.add(Integer.parseInt(x.trim()));
        }
        System.out.println(arr);

        Collections.sort(arr);
        for (int i = 0; i < arr.size() - 1; i++) {
            int cur_dis = arr.get(i + 1) - arr.get(i);
            if (cur_dis < minDistance) {
                minDistance = cur_dis;
                num1 = arr.get(i);
                num2 = arr.get(i + 1);
            }
        }

        String ans = minDistance + "," + num1 + "," + num2;
        os.write(ans.getBytes());
        os.flush();

        socket.close();
        is.close();
        os.close();
    }
}
