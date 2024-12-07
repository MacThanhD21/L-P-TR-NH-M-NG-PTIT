/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN677;

import java.rmi.registry.*;
import RMI.DataService;
import java.util.*;

public class Data_TimSoNguyenTo {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) registry.lookup("RMIDataService");
        
        int N = (int) sv.requestData("B21DCCN677", "FtkIyIfz");
        System.out.println(N);
        
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(isPrime(i)) {
                res.add(i);
            }
        }
        System.out.println(res);
        sv.submitData("B21DCCN677", "FtkIyIfz", res);
    }
    public static boolean isPrime(int N) {
        if(N < 2) return false;
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                return false;
            }
        }
        return true;
    }
}
