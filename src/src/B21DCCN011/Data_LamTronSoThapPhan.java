/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN011;

import vn.medianews.*;
import java.util.*;

public class Data_LamTronSoThapPhan {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN011", qCode = "ny8Fb8BU";
        
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        double inp = port.getDataDouble(msv, qCode);
        System.out.println(inp);
     
        double data = Math.round(inp * 100.0) / 100.0;
        int mauSo = 100;
        int tuSo = (int) Math.round(data * mauSo);
        int gcd = gcd(tuSo, mauSo);
        List<Integer> ans = new ArrayList<>(Arrays.asList(tuSo / gcd, mauSo / gcd));
        
        port.submitDataIntArray(msv, qCode, ans);
            
    }
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
