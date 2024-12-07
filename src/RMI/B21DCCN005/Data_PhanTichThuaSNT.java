/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN005;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_PhanTichThuaSNT {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");
        
        String studentCode = "B21DCCN005", qCode = "jXfnekbn";
        int N = (int) sv.requestData(studentCode, qCode);
        
        System.out.println(N);
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                while(N % i == 0) {
                    ans.add(i);
                    N /= i;
                }
            }
        }
        if(N > 1) {
            ans.add(N);
        }
        System.out.println(ans);
        sv.submitData(studentCode, qCode, ans);
    }
}
