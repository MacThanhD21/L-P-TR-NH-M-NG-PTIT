package B21DCCN001;

import vn.medianews.*;
import java.util.*;

public class DataService_PhanTichThuaSoNT {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        
        System.out.println(a);
        
        List<String> ans = new ArrayList<>();
        
        for(int x : a) {
            String tmp = "";
            for(int i = 2; i * i <= x; i++) {
                while(x % i == 0) {
                    x /= i;
                    tmp += i + ", ";
                }
            }
            if(x > 1) {
                tmp += x + ", ";
            }
            tmp = tmp.substring(0, tmp.length() - 2);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
