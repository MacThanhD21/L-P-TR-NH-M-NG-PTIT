package RMI.B21DCCN409;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_PrimeFactorization {
    public static void main(String[] args) throws Exception {
        // Kết nối đến Registry Server
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService service = (DataService) registry.lookup("RMIDataService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN409";
        String qCode = "zJ7seS1y";

        // Gửi yêu cầu để nhận số nguyên lớn N từ server
        int N = (int) service.requestData(studentCode, qCode);
        System.out.println("Received number N: " + N);

        // Phân rã N thành các thừa số nguyên tố
        List<Integer> primeFactors = getPrimeFactors(N);
        System.out.println("Prime factors of N: " + primeFactors);

        // Gửi danh sách thừa số nguyên tố về server
        service.submitData(studentCode, qCode, primeFactors);

        System.out.println("Prime factors submitted to server successfully.");
    }

    // Hàm phân rã số N thành các thừa số nguyên tố
    public static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        
        if(num > 1) {
            factors.add(num);
        }

        return factors;
    }
}
/*

[Mã câu hỏi (qCode): zJ7seS1y].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
Giao diện từ xa:
public interface DataService extends Remote {
public Object requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
Trong đó:
•	Interface DataService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một số nguyên dương lớn từ server, gọi là N.
b. Thực hiện phân rã số N thành các thừa số nguyên tố. Kết quả trả về là danh sách các thừa số nguyên tố của N.
Ví dụ: Với N = 84, kết quả là danh sách “2, 2, 3, 7”.
c. Triệu gọi phương thức submitData để gửi danh sách các thừa số nguyên tố đã tìm được trở lại server.
d. Kết thúc chương trình client.
*/