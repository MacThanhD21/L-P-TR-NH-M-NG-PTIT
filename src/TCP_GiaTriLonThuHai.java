
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_GiaTriLonThuHai {
    public static void main(String[] args) throws IOException{
        Socket soc = new Socket("203.162.10.109", 2206);
        String code = "B21DCCN018;WJY8Upxp";
        InputStream is = soc.getInputStream();
        OutputStream os = soc.getOutputStream();
        
        os.write(code.getBytes());
        os.flush();
        
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        String[] data = (new String(buf, 0, len)).trim().split(",");
        for(String x : data) {
            System.out.println(x);
        }
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(String x : data) {
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
        String ans = secMax + "," + pos;
        System.out.println(ans);
        os.write(ans.getBytes());
        os.flush();
        
        os.close();
        is.close();
        soc.close();
    }
}
