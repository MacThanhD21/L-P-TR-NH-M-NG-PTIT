/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN328;

import RMI.DataService;
import java.rmi.registry.*;
import java.util.*;

public class Data_SinhToHop {

    public static void main(String[] args) throws Exception {
        DataService sv = (DataService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMIDataService");

        String msv = "B21DCCN328", qCode = "icTLc86T";
        String inp = (String) sv.requestData(msv, qCode);
        System.out.println("Received input: " + inp);

        String[] res = inp.split("; ");

        String[] s1 = res[0].split(", ");
        int K = Integer.parseInt(res[1]);

        List<Integer> a = new ArrayList<>();

        for (String x : s1) {
            a.add(Integer.parseInt(x));
        }

        int n = a.size();
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] idx = new int[K];
        
        for(int i = 0; i < K; i++) {
            idx[i] = i;
        }
        
        while(idx[K - 1] < n) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < K; i++) {
                tmp.add(a.get(idx[i]));
            }
            ans.add(tmp);
            int t = K - 1;
            while(t >= 0 && idx[t] == n - K + t) {
                --t;
            }
            if(t >= 0) {
                idx[t]++;
                for(int i = t + 1; i < K; i++) {
                    idx[i] = idx[i - 1] + 1;
                }
            } else {
                break;
            }
        }
        
        sv.submitData(msv, qCode, ans);
    }
}
