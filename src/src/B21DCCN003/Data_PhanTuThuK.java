/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN003;

import vn.medianews.*;
import java.util.*;

public class Data_PhanTuThuK {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN003", qCode = "WpaUTFMu";

        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();

        List<Integer> data = port.getData(msv, qCode);
        System.out.println(data);
        
        // Luu y cuc kỳ quan trọng: Phải lấy K ra trước rồi mới sort
        
        int K = data.get(0); 
        
        Collections.sort(data);

        int nhoThuK = data.get(K), lonThuK = data.get(data.size() - K);

        List<Integer> ans = new ArrayList<>(Arrays.asList(lonThuK, nhoThuK));

        port.submitDataIntArray(msv, qCode, ans);
    }
}
