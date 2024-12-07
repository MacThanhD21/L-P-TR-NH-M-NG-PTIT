
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_LoaiBoKyTuTrongChuoiThuNhat {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2208);
        String code = "B21DCCN001;UqmVjVRF";
        
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        os.write(code);
        os.newLine();
        os.flush();
        
        String s1 = is.readLine();
        String s2 = is.readLine();
        
        System.out.println(s1 + " " + s2);
        
        String ans = "";
        for(char c : s1.toCharArray()) {
            if(s2.indexOf(c) == -1) {
                ans += c;
            }
        }
        os.write(ans);
        os.newLine();
        os.flush();
        
        socket.close();
        is.close();
        os.close();
    }
}
