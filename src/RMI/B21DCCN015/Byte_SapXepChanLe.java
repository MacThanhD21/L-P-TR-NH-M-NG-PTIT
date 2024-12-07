package RMI.B21DCCN015;

import java.rmi.registry.*;
import RMI.ByteService;
import java.util.*;

public class Byte_SapXepChanLe {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN015", qCode = "x3xBAbyp";

        // Nhận mảng byte từ server
        byte[] data = sv.requestData(studentCode, qCode);
        System.out.println("Original data: " + Arrays.toString(data));

        List<Byte> evenBytes = new ArrayList<>();
        List<Byte> oddBytes = new ArrayList<>();
        
        for(byte c : data) {
            if(c % 2 == 0) evenBytes.add(c);
            else oddBytes.add(c);
        }
        
        byte[] sortedData = new byte[data.length];
        int index = 0;
        for(byte x : evenBytes) {
            sortedData[index++] = x;
        }
        for(byte x : oddBytes) {
            sortedData[index++] = x;
        }

        System.out.println("Processed data (even-odd): " + Arrays.toString(sortedData));

        // Gửi mảng kết quả trở lại server
        sv.submitData(studentCode, qCode, sortedData);
        System.out.println("Data submitted successfully.");
    }
}
