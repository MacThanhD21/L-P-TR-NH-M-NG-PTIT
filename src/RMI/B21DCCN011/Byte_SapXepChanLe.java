package RMI.B21DCCN011;

import java.rmi.registry.*;
import RMI.ByteService;
import java.util.*;

public class Byte_SapXepChanLe {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN011", qCode = "2xi5AwwW";

        // Nhận mảng byte từ server
        byte[] data = sv.requestData(studentCode, qCode);
        System.out.println("Original data: " + Arrays.toString(data));

        // Phân chia mảng thành chẵn và lẻ
        List<Byte> evenBytes = new ArrayList<>();
        List<Byte> oddBytes = new ArrayList<>();

        for (byte b : data) {
            if (b % 2 == 0) {
                evenBytes.add(b);
            } else {
                oddBytes.add(b);
            }
        }

        // Kết hợp hai phần lại thành mảng kết quả
        byte[] sortedData = new byte[data.length];
        int index = 0;

        for (byte b : evenBytes) {
            sortedData[index++] = b;
        }
        for (byte b : oddBytes) {
            sortedData[index++] = b;
        }

        System.out.println("Processed data (even-odd): " + Arrays.toString(sortedData));

        // Gửi mảng kết quả trở lại server
        sv.submitData(studentCode, qCode, sortedData);
        System.out.println("Data submitted successfully.");
    }
}
