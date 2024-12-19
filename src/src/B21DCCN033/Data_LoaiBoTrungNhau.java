/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN033;

import java.util.*;
import vn.medianews.*;

public class Data_LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3";
        
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer> a = port.getData(msv, qCode);
        int[] cnt = new int[1005];
        for(int x : a) cnt[x]++;
        
        List<Integer> ans = new ArrayList<>();
        for(int x : a) {
            if(cnt[x] > 0) {
                ans.add(x);
                cnt[x] = 0;
            }
        }
        port.submitDataIntArray(msv, qCode, ans);
    }
}
