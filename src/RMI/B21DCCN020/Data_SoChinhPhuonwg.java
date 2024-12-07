/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN020;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_SoChinhPhuonwg {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");
        
        String studentCode = "B21DCCN020", qCode = "lOPNpwBe";
        int N = (int) sv.requestData(studentCode, qCode);
        System.out.println(N);
        
        List<Integer> a = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(isSCP(i)) {
                a.add(i);
            }
        }
        sv.submitData(studentCode, qCode, a);
    }
    public static boolean isSCP(int N) {
        int m = (int) Math.sqrt(N);
        return m * m == N;
    }
    
}
