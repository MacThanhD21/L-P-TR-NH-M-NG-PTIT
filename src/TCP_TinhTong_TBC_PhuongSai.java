import java.io.*;
import java.net.*;

public class TCP_TinhTong_TBC_PhuongSai {
    public static void main(String[] args) throws IOException{
        Socket soc = new Socket("203.162.10.109", 2207);
        String code = "B21DCCN025;4l4zx69c";
        
        DataInputStream is = new DataInputStream (soc.getInputStream());
        DataOutputStream os = new DataOutputStream(soc.getOutputStream());
        
        os.writeUTF(code);
        os.flush();
        
        int N = is.readInt();
        int[] a = new int[N];
        
        for(int i = 0; i < N; i++) {
            a[i] = is.readInt();
        }
        
        int sum = 0;
        for(int x : a) {
            sum += x;
        }
        float mean = (float) sum / N;
        float v = 0f;
        
        for(int x : a) {
            v += (x - mean) * (x - mean);
        }
        v /= N;
        
        os.writeInt(sum);
        os.writeFloat(mean);
        os.writeFloat(v);
        
        os.flush();
        
        os.close();
        is.close();
        soc.close();
        
    }
}
