
import java.io.*;
import java.net.*;

public class TCP_TungXucSac {

    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("203.162.10.109", 2207);
        String code = "B21DCCN050;i5hiR8U7";

        DataInputStream is = new DataInputStream(soc.getInputStream());
        DataOutputStream os = new DataOutputStream(soc.getOutputStream());

        os.writeUTF(code);
        os.flush();

        int N = is.readInt();
        int[] fre = new int[6]; // Mảng đếm số lần xuất hiện của [1,2,3,4,5,6]
        for (int i = 0; i < N; i++) {
            int x = is.readInt();
            fre[x - 1]++;
        }
        for (int count : fre) {
            float x = (float) count / N;
            os.writeFloat(x);
        }
        os.flush();

        os.close();
        is.close();
        soc.close();
    }
}
