

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_TimTuDaiNhat {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2208);
        
        String code = "B21DCCN005;afvEER9o";
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        os.write(code);
        os.newLine();
        os.flush();
        
        String inp = is.readLine();
        String[] data = inp.split("\\s+");
//        System.out.println(inp);
        String ans = "";
        for(String x : data) {
            if(x.length() > ans.length()) {
                ans = x;
            }
        }
        String index = inp.indexOf(ans) + "";
        
        System.out.println(ans + " " + index);
        
        os.write(ans);
        os.newLine();
        os.flush();
        
        os.write(index);
        os.newLine();
        os.flush();
        
        os.close();
        is.close();
        socket.close();
    }
}
