/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN025;

import java.util.*;
import vn.medianews.*;

public class Object_ConvertHe8va16 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN025", qCode = "QBDJ1GGL";
        
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        
        List<String> ans = new ArrayList<>();
        for(int n : a) {
            ans.add(Integer.toOctalString(n) + "|" + Integer.toHexString(n).toUpperCase());
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
