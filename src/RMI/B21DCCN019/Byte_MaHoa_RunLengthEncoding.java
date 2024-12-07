package RMI.B21DCCN019;

import java.rmi.registry.*;
import RMI.ByteService;
import java.util.*;

public class Byte_MaHoa_RunLengthEncoding {
    public static void main(String[] args) throws Exception {
        // Connect to RMI Registry and retrieve the ByteService4
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");

        String studentCode = "B21DCCN019", qCode = "DGKZwFFo";
        byte[] data = sv.requestData(studentCode, qCode);
        System.out.println(data);
        
        List<Byte> compressedList = new ArrayList<>();
        for(int i = 0; i < data.length; ) {
            byte curByte = data[i];
            int coun = 1;
            while(i + coun < data.length && data[i + coun] == curByte) {
                coun++;
            }
            compressedList.add(curByte);
            compressedList.add(Byte.parseByte(coun + ""));
            i += coun;
        }
        byte[] compressed = new byte[compressedList.size()];
        for(int i = 0; i < compressed.length; i++) {
            compressed[i] = compressedList.get(i);
        }
        
        sv.submitData(studentCode, qCode, compressed);
    }
}
