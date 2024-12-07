/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN002;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_CoinChange {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");
        
        String studentCode = "B21DCCN002", qCode = "dxv4dDNr";
        int inp = (int) sv.requestData(studentCode, qCode);
        System.out.println(inp);
        
        int[] coins = {10, 5, 2, 1};
        int coun = 0;
        String ans = "";
        
        for(int coin : coins) {
            while(inp >= coin) {
                inp -= coin;
                coun++;
                ans += coin + ",";
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        String result = coun + "; " + ans;
        System.out.println(result);
        
        sv.submitData(studentCode, qCode, result);
    }
}
