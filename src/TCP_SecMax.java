
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_SecMax {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        String code = "B21DCCN677;9nECje1z";
        
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        os.write(code.getBytes());
        os.flush();
        
        // Nhận data
        byte[] data = new byte[1024];
        int len = is.read(data);
        
        String dataStr = (new String(data, 0, len)).trim();
        System.out.println(dataStr);
        String[] dataArr = dataStr.split(",");
        
        // Xử lý
        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        for(String x : dataArr) {
            a.add(Integer.parseInt(x));
            b.add(Integer.parseInt(x));
        }
        Collections.sort(a);
        int secMax = a.get(a.size() - 2);
        int pos = 0;
        for(int i = 0; i < b.size(); i++) {
            if(b.get(i) == secMax) {
                pos = i;
                break;
            }
        }
        String ans = (secMax + "") + "," + (pos + "");
        System.out.println(secMax + " " + pos);
        
        os.write(ans.getBytes());
        os.flush();
        
        os.close();
        is.close();
        socket.close();
    }
}
