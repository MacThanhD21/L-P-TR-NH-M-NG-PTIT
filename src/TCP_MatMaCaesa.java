
import java.net.*;
import java.io.*;
import java.util.*;

public class TCP_MatMaCaesa {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        String code = "B21DCCN818;5fu9pr0f";

        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        os.writeUTF(code);
        os.flush();

        String inp = is.readUTF();
        System.out.println(inp);

        int s = is.readInt();
        System.out.println(s);

        String ans = "";
        
        // Giai ma: + s; s = 3, A -> D
        // Ma Hoa: -s;
        
        for(char c : inp.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            ans += (char) ((c - base + s) % 26 + base);
        }
        System.out.println(ans);
        
        os.writeUTF(ans.trim());    
        os.flush();

        socket.close();
        is.close();
        os.close();

    }
}
