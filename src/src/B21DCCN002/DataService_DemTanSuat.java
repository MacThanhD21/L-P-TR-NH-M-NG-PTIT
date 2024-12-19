package B21DCCN002;

import vn.medianews.*;
import java.util.*;

public class DataService_DemTanSuat {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "TU4ULIgh";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        // List<Integer>a = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3));
        Collections.sort(a);
        System.out.println(a);
        
        int[] cnt = new int[10005];
        for (int x : a)
            cnt[x]++;
        
        List<String> ans = new ArrayList<>();
        for (int x : a) {
            if (cnt[x] > 0) {
                String tmp = x + ", " + cnt[x];
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
