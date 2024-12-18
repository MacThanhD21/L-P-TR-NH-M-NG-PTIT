
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_SapXepCacTuTheoThuTuTuDien {
    public static void main(String[] args) throws IOException{
        Socket soc = new Socket("203.162.10.109", 2208);
        String code = "B21DCCN020;4xIki082";
        
        BufferedReader is = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
        
        os.write(code + "\n");
        os.flush();
       
        List<String> data = Arrays.asList(is.readLine().split("\\s+"));
        Collections.sort(data);
        
        os.write(String.join(" ", data) + "\n");
        os.flush();
        
        os.close();
        is.close();
        soc.close();
    }
}
