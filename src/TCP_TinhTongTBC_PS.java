
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_TinhTongTBC_PS {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        String code = "B21DCCN002;D5OIIvBN";
        
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        
        os.writeUTF(code);
        os.flush();
        
        int N = is.readInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = is.readInt();
        }
        
        int sum = 0;
        for(int num : a) {
            sum += num;
        }
        float mean = (float) sum / N;
        System.out.println(mean);
        
        float varianSum = 0;
        for(int num : a) {
            varianSum += (num - mean) * (num - mean);
        }
        float varian = varianSum / N;
        
        os.writeInt(sum);
        os.writeFloat(mean);
        os.writeFloat(varian);
        
        socket.close();
        is.close();
        os.close();
    }
}
