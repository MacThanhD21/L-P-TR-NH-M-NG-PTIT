package RMI.B21DCCN007;

import java.rmi.registry.*;
import RMI.ByteService;

public class Byte_MaHoa_RunLengthEncoding {
    public static void main(String[] args) throws Exception {
        // Connect to RMI Registry and retrieve the ByteService
        ByteService sv = (ByteService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMIByteService");

        String studentCode = "B21DCCN007", qCode = "Qf7DQ6Fc";
        byte[] data = sv.requestData(studentCode, qCode);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; ) {
            byte cur = data[i];
            int coun = 0;
            while (i < data.length && data[i] == cur) {
                coun++;
                i++;
            }
            sb.append((char) cur).append((char) coun);
        }
        sv.submitData(studentCode, qCode, sb.toString().getBytes());
    }
}
