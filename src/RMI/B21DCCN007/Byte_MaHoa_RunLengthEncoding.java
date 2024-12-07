package RMI.B21DCCN007;

import java.rmi.registry.*;
import RMI.ByteService;

public class Byte_MaHoa_RunLengthEncoding {
    public static void main(String[] args) throws Exception {
        // Connect to RMI Registry and retrieve the ByteService
        ByteService sv = (ByteService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMIByteService");

        String studentCode = "B21DCCN007", qCode = "Qf7DQ6Fc";
        byte[] data = sv.requestData(studentCode, qCode);

        byte[] compressedData = new byte[data.length * 2];
        int index = 0;
        for(int i = 0; i < data.length; ) {
            byte cur = data[i];
            int coun = 1;
            while(i + coun < data.length && data[i + coun] == cur) coun++;
            compressedData[index++] = cur;
            compressedData[index++] = (byte) coun;
            i += coun;
        }
        byte[] compressed = new byte[index];
        System.arraycopy(compressedData, 0, compressed, 0, index);
        
        sv.submitData(studentCode, qCode, compressed);
    }
}
