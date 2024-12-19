package RMI.B21DCCN012;

import java.rmi.registry.*;
import java.util.Base64;
import RMI.ByteService;

public class Byte_DecodeBase64 {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");

        String studentCode = "B21DCCN012", qCode = "aHcpoeGe";

        byte[] encodedData = sv.requestData(studentCode, qCode);

        byte[] ans = Base64.getDecoder().decode(encodedData);

        System.out.println();

        sv.submitData(studentCode, qCode, ans);
    }
}
