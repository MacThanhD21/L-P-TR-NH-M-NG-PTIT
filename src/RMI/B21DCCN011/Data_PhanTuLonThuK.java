package RMI.B21DCCN011;

import java.rmi.registry.*;
import RMI.DataService;
import java.util.*;

public class Data_PhanTuLonThuK {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");

        String studentCode = "B21DCCN011", qCode = "hWRW2Q8w";

        String input = (String) sv.requestData(studentCode, qCode);
        System.out.println("Received data: " + input);

        String[] parts = input.split(";");
        List<Integer> a = new ArrayList<>();
        String[] data = parts[0].split(", ");
        
        for(String x : data) {
            a.add(Integer.parseInt(x));
        }
        int k = Integer.parseInt(parts[1].trim());

        // Sắp xếp mảng giảm dần để tìm phần tử lớn thứ K
        Collections.sort(a);
        int kthLargest = a.get(a.size() - k);

        System.out.println("The " + k + "-th largest element is: " + kthLargest);

        // Gửi kết quả trở lại server
        sv.submitData(studentCode, qCode, kthLargest);
    }
}
