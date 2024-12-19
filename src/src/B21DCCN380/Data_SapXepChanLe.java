/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN380;

import java.util.*;
import vn.medianews.*;

public class Data_SapXepChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN380", qCode = "giqKMUNb";
        
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer> a = port.getData(msv, qCode);
        
        System.out.println(a);
        
        List<Integer> e = new ArrayList<>(), o = new ArrayList<>();
        
        for(int x : a) {
            if(x % 2 == 0) e.add(x);
            else o.add(x);
        }

        List<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i < e.size() && j < o.size()) {
            ans.add(e.get(i++));
            ans.add(o.get(j++));
        }
        
        while(i < e.size()) ans.add(e.get(i++));
        while(j < o.size()) ans.add(o.get(j++));
        
        port.submitDataIntArray(msv, qCode, ans);
    }
}
