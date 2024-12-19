/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN082;

import java.util.*;
import vn.medianews.*;

public class Data_hnVAHv3I {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN082", qCode = "hnVAHv3I";
        
        DataService_Service sv = new DataService_Service();
        DataService port = sv.getDataServicePort();
        
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        
        int sum = 0;
        for(int x : a) sum += x;
        port.submitDataInt(msv, qCode, sum);
    }
}
