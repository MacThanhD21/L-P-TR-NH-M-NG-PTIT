/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN015;

import java.util.*;
import vn.medianews.*;

public class Data_TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN015", qCode = "fCtJeDin";
        
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        
        List<String> b = new ArrayList<>();
        for(int x : a) {
            b.add(x + "");
        }
        //888 35 32 235 253
        b.sort((x, y) -> (y + x).compareTo(x + y));
        String ans = "";
        for(String x : b) ans += x;
        port.submitDataString(msv, qCode, ans);
    }
}
