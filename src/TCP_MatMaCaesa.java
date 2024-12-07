
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

        String encrypted_Data = is.readUTF();
        System.out.println(encrypted_Data);

        int shiftVal = is.readInt();
        System.out.println(shiftVal);

        String ans = "";
        
        // Giai ma: + 26; s = 3, A -> D
        // Ma Hoa: -26;
        
        for(char c : encrypted_Data.toCharArray()) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            ans += (char) ((c - base + shiftVal) % 26 + base);
        }
        
        os.writeUTF(ans.trim());    
        os.flush();

        socket.close();
        is.close();
        os.close();

    }
}
