package RMI.B21DCCN012;

import java.rmi.registry.*;
import java.util.Base64;
import RMI.ByteService;

public class Byte_DecodeBase64 {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN012", qCode = "aHcpoeGe";

        // Nhận dữ liệu Base64 dưới dạng mảng byte từ server
        byte[] encodedData = sv.requestData(studentCode, qCode);
        System.out.println("Received Base64 data: " + new String(encodedData));

        // Giải mã dữ liệu Base64 thành mảng byte nguyên bản
        byte[] originalData = Base64.getDecoder().decode(encodedData);
        System.out.print("Decoded original data: ");
        for (byte b : originalData) {
            System.out.print(b + " ");
        }
        System.out.println();

        // Gửi mảng dữ liệu gốc đã giải mã về server
        sv.submitData(studentCode, qCode, originalData);
        System.out.println("Original data submitted successfully.");
    }
}
