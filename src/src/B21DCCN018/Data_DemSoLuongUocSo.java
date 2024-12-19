/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN018;

import vn.medianews.*;
import java.util.*;

public class Data_DemSoLuongUocSo {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN018", qCode = "S0GoDigY";

        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();

        int N = (int) port.getDataDouble(msv, qCode);
        System.out.println(N);

        int coun = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                ans.add(i);
                coun++;
            }
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
