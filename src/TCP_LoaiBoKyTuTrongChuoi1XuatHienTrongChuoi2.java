
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_LoaiBoKyTuTrongChuoi1XuatHienTrongChuoi2 {
    public static void main(String[] args) throws IOException{
        Socket soc = new Socket("203.162.10.109", 2208);
        
        BufferedReader is = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
        
        String code = "B21DCCN008;wqZKM3G8";
        os.write(code);
        os.newLine();
        os.flush();
        
        String s1 = is.readLine();
        String s2 = is.readLine();
        
        String ans = "";
        for(char c : s1.toCharArray()) {
            if(s2.indexOf(c) == -1) {
                ans += c;
            }
        }
        os.write(ans);
        os.newLine();
        os.flush();
        
        os.close();
        is.close();
        soc.close();
        
    }
}
