package RMI.B21DCCN001;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import RMI.ByteService;

public class Byte_TanXuatItNhat {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) registry.lookup("RMIByteService");

        byte[] data = sv.requestData("B21DCCN001", "CVoQsSJ0");
        System.out.println(data);

        // Use Map
        Map<Byte, Integer> fre = new HashMap<>();
        for (byte b : data) {
            fre.put(b, fre.getOrDefault(b, 0) + 1);
        }
        byte minElement = data[0];
        int minFre = Integer.MAX_VALUE;
        for (byte x : data) {
            // Khong xet TH Bang tuc la lay TH Dau Tien Nho Hon
            if (fre.get(x) < minFre) {
                minFre = fre.get(x);
                minElement = x;
            }
        }
        System.out.println(minFre + " " + minElement);
        // setup data to send 
        byte[] results = {minElement, (byte) minFre};

        sv.submitData("B21DCCN001", "CVoQsSJ0", results);
    }
}
/*
[Mã câu hỏi (qCode): CVoQsSJ0].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
Giao diện từ xa:
public interface ByteService extends Remote {
public byte[] requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
Trong đó:
•	Interface ByteService được viết trong package RMI.
Đối tượng cài đặt giao diện từ xa ByteService được đăng ký với RegistryServer với tên là: RMIByteService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhị phân nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân (byte[]) từ server.
b. Tìm phần tử có số lần xuất hiện ít nhất trong mảng, nếu có nhiều phần tử có cùng số lần xuất hiện ít nhất, chỉ cần trả về phần tử đầu tiên xuất hiện trong các phần tử đó
Ví dụ: Nếu mảng dữ liệu nhận được là [1, 2, 3, 2, 1], chương trình sẽ tìm ra phần tử xuất hiện ít nhất là 3.
c. Triệu gọi phương thức submitData để gửi mảng byte kết quả chứa phẩn tử có số lần xuất hiện ít nhất và số lần xuất hiện trở lại server.
d. Kết thúc chương trình client.
 */
