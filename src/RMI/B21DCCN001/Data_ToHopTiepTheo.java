package RMI.B21DCCN001;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_ToHopTiepTheo {

    public static void main(String[] args) throws Exception {
        // Kết nối tới RMI Server
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) registry.lookup("RMIDataService");

        // Mã sinh viên và mã câu hỏi
        String studentCode = "B21DCCN001";
        String qCode = "wVQdpxeY";

        // a. Triệu gọi phương thức requestData để nhận chuỗi các số nguyên
        String receivedData = (String) sv.requestData(studentCode, qCode);
        System.out.println(receivedData);
        // Chuyển chuỗi dữ liệu thành List<Integer>
        List<Integer> numbers = new ArrayList<>();
        String[] numbersArray = receivedData.split(", ");
        for (String numStr : numbersArray) {
            numbers.add(Integer.parseInt(numStr));
        }

        System.out.println("Dữ liệu nhận được: " + numbers);

        // b. Tìm tổ hợp kế tiếp
        List<Integer> nextCombination = findNextCombination(numbers);
        System.out.println("Tổ hợp kế tiếp: " + nextCombination);

        String ans = "";
        for (int x : nextCombination) {
            ans += x + ",";
        }
        ans = ans.substring(0, ans.length() - 1);
        // c. Gửi dữ liệu tổ hợp kế tiếp trở lại server
        sv.submitData(studentCode, qCode, ans);

        // d. Kết thúc chương trình
        System.out.println("Đã gửi tổ hợp kế tiếp về server.");
    }

    // Hàm tìm tổ hợp kế tiếp
    public static List<Integer> findNextCombination(List<Integer> numbers) {
        List<Integer> nextCombination = new ArrayList<>(numbers);
        
        int n = nextCombination.size();
        int i = n - 2;
        while(i >= 0 && nextCombination.get(i) >= nextCombination.get(i + 1)) {
            --i;
        }
        if(i >= 0) {
            int j = n - 1;
            // Tìm phần tử nhỏ nhất lớn hơn a[i] ở đoạn cuối
            while(nextCombination.get(j) <= nextCombination.get(i)) {
                --j;
            }
            Collections.swap(nextCombination, i, j);
        }
        Collections.reverse(nextCombination.subList(i + 1, n));
        return nextCombination;
    }
}
