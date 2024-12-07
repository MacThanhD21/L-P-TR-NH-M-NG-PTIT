package RMI.B21DCCN001;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import RMI.ByteService;

public class Main {
    public static void main(String[] args) throws Exception {
        // Kết nối tới RegistryServer
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        
        // Tra cứu đối tượng RMI với tên "RMIByteService"
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        
        // Mã sinh viên và mã câu hỏi
        String studentCode = "B21DCCN001";
        String qCode = "CVoQsSJ0";
        
        // Triệu gọi phương thức requestData để nhận dữ liệu từ server
        byte[] data = byteService.requestData(studentCode, qCode);
        System.out.println("Dữ liệu nhận được từ server: ");
        for (byte b : data) {
            System.out.print(b + " ");
        }
        System.out.println();
        
        // Tìm phần tử xuất hiện ít nhất trong mảng
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : data) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }
        
        byte minElement = data[0];
        int minFrequency = Integer.MAX_VALUE;
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                minElement = entry.getKey();
            }
        }
        
        System.out.println("Phần tử có số lần xuất hiện ít nhất: " + minElement);
        System.out.println("Số lần xuất hiện: " + minFrequency);
        
        // Chuẩn bị mảng dữ liệu gửi lại server
        byte[] result = new byte[2];
        result[0] = minElement;
        result[1] = (byte) minFrequency;
        
        // Triệu gọi phương thức submitData để gửi dữ liệu trở lại server
        byteService.submitData(studentCode, qCode, result);
        System.out.println("Kết quả đã được gửi lên server.");
    }
}
