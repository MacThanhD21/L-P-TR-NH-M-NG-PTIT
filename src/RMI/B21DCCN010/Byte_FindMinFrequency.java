package RMI.B21DCCN010;

import java.rmi.registry.*;
import RMI.ByteService;
import java.util.*;

public class Byte_FindMinFrequency {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN010", qCode = "xO08HHJj";

        byte[] data = sv.requestData(studentCode, qCode);
        Map<Byte, Integer> mp = new HashMap<>();
        
        for(byte b : data) {
            mp.put(b, mp.getOrDefault(b, 0) + 1);
        }
        byte minEle = 0;
        int minFre = Integer.MAX_VALUE;
        
        for(byte b : data) {
            int cur_Fre = mp.get(b);
            if(cur_Fre < minFre) {
                minFre = cur_Fre;
                minEle = b;
            }
        }
        byte[] result = {minEle, (byte) minFre};
        
        // Gửi kết quả về server
        sv.submitData(studentCode, qCode, result);
        System.out.println("Data submitted successfully.");
    }
}
