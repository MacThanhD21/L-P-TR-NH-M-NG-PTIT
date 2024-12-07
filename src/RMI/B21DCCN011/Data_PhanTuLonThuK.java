package RMI.B21DCCN011;

import java.rmi.registry.*;
import RMI.DataService;
import java.util.*;

public class Data_PhanTuLonThuK {
    public static void main(String[] args) throws Exception {
        // Kết nối tới Registry và lấy đối tượng từ xa
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");

        // Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN011", qCode = "hWRW2Q8w";

        // Nhận dữ liệu từ server
        String input = (String) sv.requestData(studentCode, qCode);
        System.out.println("Received data: " + input);

        // Tách mảng và giá trị K từ chuỗi nhận được
        String[] parts = input.split(";");
        int[] numbers = Arrays.stream(parts[0].trim().split(", "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        int k = Integer.parseInt(parts[1].trim());

        // Sắp xếp mảng giảm dần để tìm phần tử lớn thứ K
        Arrays.sort(numbers);
        int kthLargest = numbers[numbers.length - k];

        System.out.println("The " + k + "-th largest element is: " + kthLargest);

        // Gửi kết quả trở lại server
        sv.submitData(studentCode, qCode, kthLargest);
        System.out.println("Result submitted successfully.");
    }
}
