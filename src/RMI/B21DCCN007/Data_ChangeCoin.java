/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN007;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_ChangeCoin {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");
        
        String studentCode = "B21DCCN007", qCode = "b15NqTy4";
        
        int N = (int) sv.requestData(studentCode, qCode);
        System.out.println(N);
        
        int coun = 0;
        int[] coins = {10, 5, 2, 1};
        
        String ans = "";
        for(int coin : coins) {
            while(N >= coin) {
                N -= coin;
                coun++;
                ans += coin + ",";
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        ans = coun + "; " + ans;
        
        sv.submitData(studentCode, qCode, ans);
//        sv.submitData(studentCode, qCode, result);
        
    }
}
