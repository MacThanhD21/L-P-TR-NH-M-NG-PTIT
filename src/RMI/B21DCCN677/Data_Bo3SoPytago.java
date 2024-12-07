package RMI.B21DCCN677;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_Bo3SoPytago {
    public static void main(String[] args) throws Exception {
        // Kết nối RMI server
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) registry.lookup("RMIDataService");

        // a. Nhận số nguyên dương N từ server
        int N = (int) sv.requestData("B21DCCN677", "HiM9hLOT");
        System.out.println("Giới hạn N: " + N);

        // b. Tìm danh sách các bộ ba số Pythagore
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a); triple.add(b); triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }

        System.out.println("Danh sách các bộ ba số Pythagore: " + res);

        // c. Gửi danh sách kết quả lên server
        sv.submitData("B21DCCN677", "HiM9hLOT", res);
    }
}
