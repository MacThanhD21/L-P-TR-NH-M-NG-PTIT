/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN030;

import java.util.*;
import RMI.DataService;
import java.rmi.registry.*;

public class Data_ToHopTiepTheo {

    public static void main(String[] args) throws Exception {
        DataService sv = (DataService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMIDataService");

        String msv = "B21DCCN030", qCode = "BnaalaKe";
        String[] inp = ((String) sv.requestData(msv, qCode)).split(", ");

        List<Integer> a = new ArrayList<>();
        for (String x : inp) {
            a.add(Integer.parseInt(x));
        }

        List<Integer> nextC = new ArrayList<>(a);
        int n = nextC.size();
        int i = n - 2;

        while (i >= 0 && nextC.get(i) >= nextC.get(i + 1)) {
            --i;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nextC.get(j) <= nextC.get(i)) {
                --j;
            }
            Collections.swap(nextC, i, j);
        }
        Collections.reverse(nextC.subList(i + 1, n));
        String ans = "";
        for(int x : nextC) ans += "," + x;
        ans = ans.substring(1);
        sv.submitData(msv, qCode, ans);
    }

}
