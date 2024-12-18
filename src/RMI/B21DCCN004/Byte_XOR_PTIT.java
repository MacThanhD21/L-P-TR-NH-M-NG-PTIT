
package RMI.B21DCCN004;

import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class Byte_XOR_PTIT {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        
        String msv = "B21DCCN004", qCode = "Yo4r28BW";
        byte[] data = sv.requestData(msv, qCode);
        
        System.out.println(data);
        
        byte[] encodeData = new byte[data.length];
        byte[] keyBytes = "PTIT".getBytes();
        
        for(int i = 0; i < data.length; i++) {
            encodeData[i] = (byte) (data[i] ^ keyBytes[i % keyBytes.length]);
        }
        
        sv.submitData(msv, qCode, encodeData);
    }
}
