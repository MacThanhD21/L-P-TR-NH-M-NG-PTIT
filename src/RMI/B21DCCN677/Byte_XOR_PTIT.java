
package RMI.B21DCCN677;

import java.rmi.registry.*;
import RMI.ByteService;

public class Byte_XOR_PTIT {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) registry.lookup("RMIByteService");
        
        byte[] receivedData = sv.requestData("B21DCCN677", "ryjlDHvU");
        System.out.println(receivedData);
        
        // process
        byte[] keyBytes = "PTIT".getBytes();
        byte[] encodedData = new byte[receivedData.length];
        
        for(int i = 0 ; i < receivedData.length; i++) {
            encodedData[i] = (byte) (receivedData[i] ^ keyBytes[i % keyBytes.length]);
        }
        
        sv.submitData("B21DCCN677", "ryjlDHvU", encodedData);
    }
}
