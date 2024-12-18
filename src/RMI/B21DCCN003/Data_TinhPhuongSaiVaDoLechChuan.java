/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN003;


import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_TinhPhuongSaiVaDoLechChuan {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");
        
        String studentCode = "B21DCCN003", qCode = "QZ8jT0DC";
        String inp = (String) sv.requestData(studentCode, qCode);
        
        List<Double> data = new ArrayList<>();

        String[] res = inp.split(", ");
        for(String x : res) {
            data.add(Double.parseDouble(x));
        }
        System.out.println(inp);
        
        int n = data.size();
        
        double sum = 0.0, sumOfSquare = 0.0;
        for(double num : data) {
            sum += num;
            sumOfSquare += (num * num);
        }
        // B1. Tinh trung binh - mean
        double mean = (double) sum / n;
        // B2. Tinh phuong sai - variance
        double varian = (sumOfSquare / n) - (mean * mean);
        double dolechchuan = Math.sqrt(varian);
        
        varian = Math.round(varian * 100.0) / 100.0;
        dolechchuan = Math.round(dolechchuan * 100.0) / 100.0;
        
        
        String result = varian + " : " + dolechchuan;
        sv.submitData(studentCode, qCode, result);
        
    }
}
