/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN004;

import vn.medianews.*;
import java.util.*;

public class Data_DemUocSoCuaPhanNguyen_Double {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F";
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        int a = (int) port.getDataDouble(msv, qCode);
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1; i <= a; i++) {
            if(a % i == 0) ans.add(i);
        }
        ans.add(0, ans.size());
        port.submitDataIntArray(msv, qCode, ans);
        
    }
}
