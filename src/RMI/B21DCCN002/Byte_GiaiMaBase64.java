package RMI.B21DCCN002;

import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class Byte_GiaiMaBase64 {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        
        String studentCode = "B21DCCN002", qCode = "XwgdSU5o";
        
        byte[] encode = sv.requestData(studentCode, qCode);
        
        byte[] decode = Base64.getDecoder().decode(encode);
        
        sv.submitData(studentCode, qCode, decode);
    }
}
