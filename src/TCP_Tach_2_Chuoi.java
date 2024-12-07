
import java.net.*;
import java.io.*;
import java.util.*;

public class TCP_Tach_2_Chuoi {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2208);
        String code = "B21DCCN677;MaN88IWt";
        
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        os.write(code);
        os.newLine();
        os.flush();
        
        String res = is.readLine();
        System.out.println(res);
        
        String alpha_Str = "", special_Str = "";
        for(char c : res.toCharArray()) {
            // isLetterOrDigit
            if(Character.isLetterOrDigit(c)) {
                alpha_Str += c;
            }
            else {
                special_Str += c;
            }
        }
        
        System.out.println(alpha_Str + " " + special_Str);
        os.write(alpha_Str);
        os.newLine();
        os.flush();
        
        os.write(special_Str);
        os.newLine();
        os.flush();
        
        socket.close();
        is.close();
        os.close();
        
    }
}
