package RMI.B21DCCN319;

import RMI.DataService;
import java.rmi.registry.*;
import java.util.*;

public class Data_SinhToHop {

    // Hàm sinh tổ hợp với danh sách và số phần tử k
    public static List<List<Integer>> generateCombinations(List<Integer> elements, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        int n = elements.size();
        int[] indices = new int[k];

        // Khởi tạo tổ hợp đầu tiên
        for (int i = 0; i < k; i++) {
            indices[i] = i;
        }

        // Sinh tổ hợp
        while (true) {
            // Thêm tổ hợp hiện tại vào danh sách kết quả
            List<Integer> combination = new ArrayList<>();
            for (int index : indices) {
                combination.add(elements.get(index));
            }
            combinations.add(combination);

            // Sinh tổ hợp kế tiếp
            int i = k - 1;
            while (i >= 0 && indices[i] == n - k + i) {
                i--;
            }
            if (i < 0) {
                break; // Không còn tổ hợp nào khác
            }
            indices[i]++;
            for (int j = i + 1; j < k; j++) {
                indices[j] = indices[j - 1] + 1;
            }
        }

        return combinations;
    }

    public static List<String> formatCombinations(List<List<Integer>> combinations) {
        List<String> formattedList = new ArrayList<>();
        for (List<Integer> combination : combinations) {
            formattedList.add(combination.stream()
                    .map(String::valueOf)
                    .reduce((a, b) -> a + "," + b)
                    .orElse(""));
        }
        return formattedList;
    }

    public static void main(String[] args) throws Exception {
        // Kết nối RMI Server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN319", "L8oLzVFS");
        System.out.println(s);

        // Tách dữ liệu đầu vào
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());
        List<Integer> elements = new ArrayList<>();

        for (String x : s1.split(",")) {
            elements.add(Integer.parseInt(x.trim()));
        }

        // Sinh tổ hợp
        List<List<Integer>> combinations = generateCombinations(elements, k);
        System.out.println(combinations);
        // Định dạng tổ hợp thành danh sách chuỗi
//        List<String> formattedCombinations = formatCombinations(combinations);
//        System.out.println(formattedCombinations);

        // Gửi danh sách chuỗi lên server
        sv.submitData("B21DCCN319", "L8oLzVFS", combinations);
    }

}

/*

[Mã câu hỏi (qCode): L8oLzVFS].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
Giao diện từ xa:
public interface DataService extends Remote {
public Object requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
Trong đó:
•	Interface DataService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một chuỗi gồm tập hợp số nguyên và một số nguyên K từ server với định dạng: “mảng; số nguyên K”.
b. Sử dụng thuật toán sinh tổ hợp để tạo ra tất cả các tổ hợp kích thước K của tập hợp đã cho. Kết quả trả về là danh sách các tổ hợp con có K phần tử.
Ví dụ: Với tập hợp [1, 2, 3, 4] và K = 2, kết quả là danh sách các tổ hợp [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]].
c. Triệu gọi phương thức submitData để gửi List<List<Integer>> chứa danh sách các tổ hợp đã sinh được trở lại server.
d. Kết thúc chương trình client.
*/
